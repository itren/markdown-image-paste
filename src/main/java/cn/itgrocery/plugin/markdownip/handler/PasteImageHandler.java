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
package cn.itgrocery.plugin.markdownip.handler;

import cn.itgrocery.plugin.markdownip.config.QiNiuConfig;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorModificationUtil;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.vfs.VirtualFile;
import cn.itgrocery.plugin.markdownip.util.ImageUtils;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static cn.itgrocery.plugin.markdownip.util.ImageUtils.save;
import static cn.itgrocery.plugin.markdownip.util.ImageUtils.toBufferedImage;

/**
 * @Author chenxl
 * @Date 2017/9/1 16:13
 * @Describle
 */
public class PasteImageHandler extends EditorActionHandler {

    private final EditorActionHandler myOriginalHandler;


    public PasteImageHandler(EditorActionHandler originalAction) {

        myOriginalHandler = originalAction;
    }

    @Override
    protected void doExecute(Editor editor, @Nullable Caret caret, DataContext dataContext) {

        if (editor instanceof EditorEx) {
            VirtualFile virtualFile = ((EditorEx) editor).getVirtualFile();
            if (virtualFile != null) {
                FileType fileType = virtualFile.getFileType();
                if ("Markdown".equals(fileType.getName())) {
                    Image imageFromClipboard = ImageUtils.getImageFromClipboard();
                    if (imageFromClipboard != null) {
                        assert caret == null : "Invocation of 'paste' operation for specific caret is not supported";

                        BufferedImage bufferedImage = toBufferedImage(imageFromClipboard);
                        QiNiuConfig.State state = QiNiuConfig.getinstance().state;
                        String accessKey = state.accessKey;
                        String secretKey = state.secretKey;
                        String bucket = state.bucket;
                        String upHost = state.upHost;
                        try {
                            String key = save(bufferedImage, "png", accessKey, secretKey, bucket);
                            String imageUrl = upHost + "/" + key;
                            Runnable r = () -> EditorModificationUtil.insertStringAtCaret(editor, "![](" + imageUrl + ")");
                            WriteCommandAction.runWriteCommandAction(editor.getProject(), r);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        return;
                    }
                }
            }
        }

        if (myOriginalHandler != null) {
            myOriginalHandler.execute(editor, caret, dataContext);
        }
    }
}
