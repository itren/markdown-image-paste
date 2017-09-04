package cn.itgrocery.plugin.markdownip.config;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import jetbrains.buildServer.messages.serviceMessages.ServiceMessage;
import org.jetbrains.annotations.Nullable;

@State(
        name = "markdown-image-paste-local",
        storages = {
                @Storage(
                        id = "markdown-image-paste-local",
                        file = "$APP_CONFIG$/markdown-image-paste-local_config.xml"
                )
        })
public class LocalConfig implements PersistentStateComponent<LocalConfig.State>{


    public static LocalConfig getInstance(){

        return ServiceManager.getService(LocalConfig.class);
    }

    @Nullable
    @Override
    public State getState() {
        return state;
    }

    @Override
    public void loadState(State state) {

        XmlSerializerUtil.copyBean(state,this.state);
    }

    public State state = new State();

    public static final class State{

        public boolean saveLoal;
        public String preFix;

    }
}
