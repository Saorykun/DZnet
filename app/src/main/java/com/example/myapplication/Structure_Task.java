package com.example.myapplication;

public class Structure_Task {

    private String text;
    private int id;
    private String answer;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setAnswer(double answer) {
        this.answer = checkAnswer(answer);
    }

    public String checkAnswer(double answer) {
        String trueAnswer = Double.toString(answer);
        int i = 0;
        if (trueAnswer.length() > 7) {
            trueAnswer = Double.toString(answer).substring(0, Double.toString(answer).length() - 3);
            String tt = trueAnswer.substring(trueAnswer.length() - 1);
            if ((tt.equals("0"))) {
                while (trueAnswer.endsWith("0") || trueAnswer.endsWith(".")) {
                    if (trueAnswer.endsWith(".")) {
                        trueAnswer = trueAnswer.substring(0, trueAnswer.length() - 1);

                        return trueAnswer;
                    }
                    trueAnswer = trueAnswer.substring(0, trueAnswer.length() - 1);
                }
            } else {
                while (trueAnswer.endsWith("9") || trueAnswer.endsWith(".")) {
                    if (trueAnswer.endsWith(".")) {
                        trueAnswer = trueAnswer.substring(0, trueAnswer.length() - 1);
                        while (trueAnswer.substring(trueAnswer.length() - 1 - i, trueAnswer.length() - i).equals("9")) {
                            i++;
                        }
                        String tmp = trueAnswer.substring(trueAnswer.length() - 1 - i, trueAnswer.length() - i);
                        trueAnswer = trueAnswer.substring(0, trueAnswer.length() - 1 - i) + (Integer.parseInt(tmp) + 1);
                        for (; i > 0; i--)
                            trueAnswer += 0;
                        return trueAnswer;
                    }
                    trueAnswer = trueAnswer.substring(0, trueAnswer.length() - 1);
                }
                String tmp = trueAnswer.substring(trueAnswer.length() - 1);
                trueAnswer = trueAnswer.substring(0, trueAnswer.length() - 1) + (Integer.parseInt(tmp) + 1);
            }
            return trueAnswer;
        } else {
            String tt = trueAnswer.substring(trueAnswer.length() - 1);
            if ((tt.equals("0"))) {
                while (trueAnswer.endsWith("0") || trueAnswer.endsWith(".")) {
                    if (trueAnswer.endsWith(".")) {
                        trueAnswer = trueAnswer.substring(0, trueAnswer.length() - 1);

                        return trueAnswer;
                    }
                    trueAnswer = trueAnswer.substring(0, trueAnswer.length() - 1);
                }
            }
            return trueAnswer;
        }
    }

    public void setAnswer(int answer) {
        this.answer = Integer.toString(answer);
    }
}
