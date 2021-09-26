package raxcl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//新增可视化界面，让工具使用更加便捷
public class ViewReplace extends JFrame implements ActionListener {
    JFrame mainframe;
    JPanel panel;
    //输入需求内容
    JLabel inputNeed = new JLabel("请输入需求代码：");
    JTextArea inputNeedTxt = new JTextArea();
    //执行脚本按钮
    JButton startButton = new JButton("点我开始生成！");

    //方法入口
    public void viewWin(){
        mainframe = new JFrame("raxcl---多语言模板生成工具");
        mainframe.setSize(575,550);
        //设置默认关闭操作
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setResizable(false);
        //初始化面板
        initPanel();
        //展示面板
        mainframe.add(panel);
        mainframe.setVisible(true);
    }

    public void initPanel() {
        this.panel = new JPanel();
        panel.setLayout(null);
        //输入文本框
        inputNeed.setBounds(10,10,320,25);
        this.panel.add(inputNeed);
        inputNeedTxt.setBounds(10,35,500,300);
        this.panel.add(inputNeedTxt);
        //开始执行替换脚本
        startButton.setBounds(200,380,150,100);
        this.panel.add(startButton);
        //增加动作监听
        startButton.addActionListener(this);
    }

    //单击动作触发方法
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == startButton){
            //执行多语言生成方法
            ReplaceWithView replaceWithView = new ReplaceWithView();
            replaceWithView.buildMoreLanguage(inputNeedTxt.getText());
        }
    }

    public static void main(String[] args) {
        ViewReplace viewReplace = new ViewReplace();
        viewReplace.viewWin();
    }

}
