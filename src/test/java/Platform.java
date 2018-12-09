import org.apache.commons.codec.binary.StringUtils;

/**
 * Description:
 * User: daipeng
 * Date: 2018-12-06 9:52
 * Project:CodeSnippet
 */

public enum Platform {
    ANDROID(0),
    IOS(1),
    TOUCH(2);
    private final Integer value;
    private Platform(Integer value){
        this.value = value;
    }

    public Platform getPlatform(Integer value) {
        Platform platform ;
        switch (value) {
            case 0:
                platform = Platform.ANDROID;
                break;
            case 1:
                platform = Platform.IOS;
                break;
            case 2:
                platform = Platform.TOUCH;
                break;
                default:
                    platform = Platform.ANDROID;
        }
        return platform;
    }




}
