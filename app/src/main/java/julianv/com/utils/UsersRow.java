package julianv.com.utils;

/**
 * @link http://danielme.com/2013/10/09/diseno-android-listview-con-checkbox/
 * @author danielme.com
 */
public class UsersRow {
    private String title;

    private String subtitle;

    private boolean checked;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getSubtitle()
    {
        return subtitle;
    }

    public void setSubtitle(String subtitle)
    {
        this.subtitle = subtitle;
    }

    public boolean isChecked()
    {
        return checked;
    }

    public void setChecked(boolean checked)
    {
        this.checked = checked;
    }

}
