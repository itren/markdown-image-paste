package cn.itgrocery.plugin.markdownip.action;

import cn.itgrocery.plugin.markdownip.view.QiNiuSettingView;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.DialogBuilder;

import javax.swing.*;

/**
 *
 * @author Shannon Chen
 */
public class QiNiuPreferences extends AnAction{


    private static final String OK = "OK";
    public static final String QINIU_ACCESS_KEY = "qiniu_access_key";
    public static final String QINIU_SECRET_KEY = "qiniu_secret_key";
    public static final String QINIU_BUCKET = "qiniu_bucket";
    public static final String QINIU_UP_HOST = "qiniu_up_host";

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {

        showQiNiuSettingView();
    }

    private void showQiNiuSettingView() {
        DialogBuilder builder = new DialogBuilder();
        QiNiuSettingView qiNiuSettingView = new QiNiuSettingView();
        JPanel settingContainer = qiNiuSettingView.getSettingContainer();
        JTextField accessKeyTextField = qiNiuSettingView.getAccessKeyTextField();
        JTextField secretKeyTextField = qiNiuSettingView.getSecretKeyTextField();
        JTextField bucketTextField = qiNiuSettingView.getBucketTextField();
        JTextField upHostTextField = qiNiuSettingView.getUpHostTextField();
        builder.setCenterPanel(settingContainer);
        builder.addOkAction();
        builder.addCancelAction();
        builder.show();
    }
}
