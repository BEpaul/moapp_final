package edu.skku.cs.termproject;
// 안쓰게 되면 삭제


public class StepButton {

    public String stepText;
    public String stepBtn;

    public StepButton(String stepText, String stepBtn) {
        this.stepText = stepText;
        this.stepBtn = stepBtn;
    }

    public String getStepText() {
        return stepText;
    }

    public void setStepText(String stepText) {
        this.stepText = stepText;
    }

    public String getStepBtn() {
        return stepBtn;
    }

    public void setStepBtn(String stepBtn) {
        this.stepBtn = stepBtn;
    }
}
