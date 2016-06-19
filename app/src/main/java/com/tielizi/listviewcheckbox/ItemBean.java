package com.tielizi.listviewcheckbox;

/**
 * Created by Administrator on 2015/10/20.
 */
public class ItemBean {
    private int pictureId;
    private String grade;
    private String name;
    private boolean isSelect;
    private boolean isShowCheckBox;
    private boolean isButtonViewShow;

    public boolean isButtonViewShow() {
        return isButtonViewShow;
    }

    public void setIsButtonViewShow(boolean isButtonViewShow) {
        this.isButtonViewShow = isButtonViewShow;
    }

    public boolean isShowCheckBox() {
        return isShowCheckBox;
    }

    public void setIsShowCheckBox(boolean isShowCheckBox) {
        this.isShowCheckBox = isShowCheckBox;
    }

    public ItemBean(int pictureId, String grade, String name, boolean isSelect,boolean isShowCheckBox,boolean isButtonViewShow) {
        this.pictureId = pictureId;
        this.grade = grade;
        this.name = name;
        this.isSelect = isSelect;
        this.isButtonViewShow = isButtonViewShow;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



    public boolean isSelect() {
        return isSelect;
    }

    public void setIsSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }
}
