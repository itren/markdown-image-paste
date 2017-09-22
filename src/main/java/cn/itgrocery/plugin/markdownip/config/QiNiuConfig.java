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
package cn.itgrocery.plugin.markdownip.config;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nullable;

/**
 * @Author chenxl
 * @Date 2017/8/31 18:50
 * @Describle
 */
@State(
        name = "markdown-image-paste-qiniu",
        storages = {
                @Storage(
                        id = "markdown-image-paste-qiniu",
                        file = "$APP_CONFIG$/markdown-image-paste-qiniu_config.xml"
                )
        })
public class QiNiuConfig implements PersistentStateComponent<QiNiuConfig.State> {
    @Nullable
    @Override
    public QiNiuConfig.State getState() {
        return this.state;
    }

    @Override
    public void loadState(QiNiuConfig.State state) {

        XmlSerializerUtil.copyBean(state, this.state);
    }

    public static QiNiuConfig getinstance() {

        return ServiceManager.getService(QiNiuConfig.class);
    }

    public State state = new State();

    public static class State {

        public String accessKey;
        public String secretKey;
        public String bucket;
        public String upHost;
        public QINIU_ZONE zone;


    }

    public enum QINIU_ZONE {

        QINIU_ZONE_EASE_CHINA("east_china"), QINIU_ZONE_NORTH_CHINA("north_china"),
        QINIU_ZONE_SOUTH_CHINA("south_china"), QINIU_ZONE_NORTH_AMERICA("north_america");

        QINIU_ZONE(String zone) {

            this.zone = zone;
        }

        private String zone;


        @Override
        public String toString() {
            return "QINIU_ZONE{" +
                    "zone='" + zone + '\'' +
                    '}';
        }
    }
}
