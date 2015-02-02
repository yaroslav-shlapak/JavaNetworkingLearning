package tcpclientserver;

/**
 * Created by y.shlapak on Feb 02, 2015.
 */
public class LightControlJson {
    public LightControlJson(boolean lightEnabled, int lightLevel) {
        this.lightEnabled = lightEnabled;
        this.lightLevel = lightLevel;
    }

    private boolean lightEnabled;

    public boolean isLightEnabled() {
        return lightEnabled;
    }

    public void setLightEnabled(boolean lightEnabled) {
        this.lightEnabled = lightEnabled;
    }

    public int getLightLevel() {
        return lightLevel;
    }

    public void setLightLevel(int lightLevel) {
        this.lightLevel = lightLevel;
    }

    private int lightLevel;
    LightControlJson() {

    }
}
