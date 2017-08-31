package cn.itgrocery.plugin.markdownip.view;

import javax.swing.*;

/**
 * @author Shannon Chen
 *
 */
public class QiNiuSettingView {
    private JPanel settingContainer;
    private JTextField accessKeyTextField;
    private JTextField secretKeyTextField;
    private JTextField bucketTextField;
    private JTextField upHostTextField;
    private JButton okButton;
    private JButton cancelButton;

    public JPanel getSettingContainer() {
        return settingContainer;
    }

    public void setSettingContainer(JPanel settingContainer) {
        this.settingContainer = settingContainer;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("QiNiuSettingView");
        frame.setContentPane(new QiNiuSettingView().settingContainer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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
}
