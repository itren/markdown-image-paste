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
