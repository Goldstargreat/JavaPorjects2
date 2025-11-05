package center_frame;

import java.awt.*;

public class CenterFrame {
    private int x, y, fw, fh; //fw(Frame Width), fh(Frame Height)

    public CenterFrame(int fw, int fh) {
        this.fw = fw;
        this.fh = fh;
    }

    public void centerXY(){
        Toolkit toolkit = Toolkit.getDefaultToolkit(); // 시스템의 디스플레이 정보를 얻는다.
        Dimension screenSize = toolkit.getScreenSize(); // 화면의 전체 해상도(가로 x 세로)를 구한다.
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        x = screenWidth/2 - fw/2;
        y = screenHeight/2 - fh/2;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getFw() {
        return fw;
    }

    public void setFw(int fw) {
        this.fw = fw;
    }

    public int getFh() {
        return fh;
    }

    public void setFh(int fh) {
        this.fh = fh;
    }
}