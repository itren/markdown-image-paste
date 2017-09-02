/**
 * MIT License
 * <p>
 * Copyright (c) 2017 Shannon Chen
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package cn.itgrocery.plugin.markdownip.view;

import cn.itgrocery.plugin.markdownip.config.LocalConfig;
import cn.itgrocery.plugin.markdownip.config.QiNiuConfig;
import cn.itgrocery.plugin.markdownip.util.QiNiuUtils;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.util.Comparing;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Shannon Chen
 */
public class SettingView implements Configurable {

    private JPanel settingContainer;
    private JTextField accessKeyTextField;
    private JTextField secretKeyTextField;
    private JTextField bucketTextField;
    private JTextField upHostTextField;
    private JRadioButton eastChinaRadioButton;
    private JRadioButton nortChinaRadioButton;
    private JRadioButton southChinaRadioButton;
    private JRadioButton northAmeriaRadioButton;
    private JButton clickTestingButton;
    private JCheckBox alwaysSaveImageInCheckBox;
    private JTextField markdownImagePasteTextField;
    private JButton okButton;
    private JButton cancelButton;

    private QiNiuConfig.State qiNiuState = QiNiuConfig.getinstance().state;
    private LocalConfig.State localState = LocalConfig.getInstance().state;


    public SettingView() {

        intiView();

        addListener();

    }

    private void addListener() {

        clickTestingButton.addActionListener(e -> {

            String accessKeyTextFieldText = accessKeyTextField.getText();
            String secretKeyTextFieldText = secretKeyTextField.getText();
            String bucketTextFieldText = bucketTextField.getText();
            String token = QiNiuUtils.getToken(accessKeyTextFieldText, secretKeyTextFieldText, bucketTextFieldText);
            System.out.println("testing: " + token);
        });

    }


    private void intiView() {


        initLocalConfigView();

        accessKeyTextField.setText(qiNiuState.accessKey);
        secretKeyTextField.setText(qiNiuState.secretKey);
        bucketTextField.setText(qiNiuState.bucket);
        upHostTextField.setText(qiNiuState.upHost);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(eastChinaRadioButton);
        buttonGroup.add(nortChinaRadioButton);
        buttonGroup.add(southChinaRadioButton);
        buttonGroup.add(northAmeriaRadioButton);


    }

    private void initLocalConfigView() {

        if (localState.saveLoal) {

            alwaysSaveImageInCheckBox.setSelected(true);
        } else {

            alwaysSaveImageInCheckBox.setSelected(false);
        }

        markdownImagePasteTextField.setText(localState.preFix);

    }

    public JPanel getSettingContainer() {
        return settingContainer;
    }

    public void setSettingContainer(JPanel settingContainer) {
        this.settingContainer = settingContainer;
    }

    public JTextField getAccessKeyTextField() {
        return accessKeyTextField;
    }

    public void setAccessKeyTextField(JTextField accessKeyTextField) {
        this.accessKeyTextField = accessKeyTextField;
    }

    public JTextField getSecretKeyTextField() {
        return secretKeyTextField;
    }

    public void setSecretKeyTextField(JTextField secretKeyTextField) {
        this.secretKeyTextField = secretKeyTextField;
    }

    public JTextField getBucketTextField() {
        return bucketTextField;
    }

    public void setBucketTextField(JTextField bucketTextField) {
        this.bucketTextField = bucketTextField;
    }

    public JTextField getUpHostTextField() {
        return upHostTextField;
    }

    public void setUpHostTextField(JTextField upHostTextField) {
        this.upHostTextField = upHostTextField;
    }

    public JButton getOkButton() {
        return okButton;
    }

    public void setOkButton(JButton okButton) {
        this.okButton = okButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "Markdown Image Paste";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        return settingContainer;
    }

    @Override
    public boolean isModified() {
        if (Comparing.equal(qiNiuState.accessKey, accessKeyTextField.getText())
                && Comparing.equal(qiNiuState.secretKey, secretKeyTextField.getText())
                && Comparing.equal(qiNiuState.bucket, bucketTextField.getText())
                && Comparing.equal(qiNiuState.upHost, upHostTextField.getText())
                && Comparing.equal(localState.preFix, alwaysSaveImageInCheckBox.isSelected())
                && Comparing.equal(localState.preFix, markdownImagePasteTextField.getText())) {

            return false;
        } else {

            return true;
        }
    }

    @Override
    public void apply() throws ConfigurationException {

        localState.saveLoal = alwaysSaveImageInCheckBox.isSelected();
        localState.preFix = markdownImagePasteTextField.getText();

        qiNiuState.accessKey = accessKeyTextField.getText();
        qiNiuState.secretKey = secretKeyTextField.getText();
        qiNiuState.bucket = bucketTextField.getText();
        qiNiuState.upHost = upHostTextField.getText();

        System.out.println("***** APPLAY *****");
        System.out.println(qiNiuState.accessKey);
        System.out.println(qiNiuState.secretKey);
        System.out.println(qiNiuState.bucket);
        System.out.println(qiNiuState.upHost);
        System.out.println("***** END ********");

    }
}
