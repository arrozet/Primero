package gui;

import java.awt.event.ActionListener;


public interface ViewRank {
    enum Command{CLICK,CREATE, BYNAME, BYRANK, SIMULATE, SWITCH};
    void controler(ActionListener ctr);
    String getFileName();
    String getSiteName();
    void addOutputLine(String line);
    void setError(String msg);
}
