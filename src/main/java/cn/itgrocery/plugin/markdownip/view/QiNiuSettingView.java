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

import cn.itgrocery.plugin.markdownip.config.QiNiuConfig;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * @author Shannon Chen
 */
public class QiNiuSettingView implements Configurable{

    private JPanel settingContainer;
    private JTextField accessKeyTextField;
    private JTextField secretKeyTextField;
    private JTextField bucketTextField;
    private JTextField upHostTextField;
    private JButton okButton;
    private JButton cancelButton;

    private QiNiuConfig qiNiuConfig = QiNiuConfig.getinstance();
    private QiNiuConfig.State state = qiNiuConfig.state;


    public QiNiuSettingView() {


//        intiView();
        setListener();

    }

    private void setListener() {

        accessKeyTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                state.accessKey = accessKeyTextField.getText();
                System.out.println("accessKey insert: " + state.accessKey);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                state.accessKey = accessKeyTextField.getText();
                System.out.println("accessKey remove: " + state.accessKey);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                state.accessKey = accessKeyTextField.getText();
                System.out.println("accessKey change: " + state.accessKey);
            }
        });

        secretKeyTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                state.secretKey = secretKeyTextField.getText();
                System.out.println("secretKey: " + state.secretKey);
            }
        });

        bucketTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                state.bucket = bucketTextField.getText();
                System.out.println("bucket: " + state.bucket);
            }
        });

        upHostTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                state.upHost = upHostTextField.getText();
                System.out.println("upHost: " + state.upHost);
            }
        });

    }

    private void intiView() {

        accessKeyTextField.setText(state.accessKey);
        secretKeyTextField.setText(state.secretKey);
        bucketTextField.setText(state.bucket);
        upHostTextField.setText(state.upHost);
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
        return false;
    }

    @Override
    public void apply() throws ConfigurationException {

    }
}
