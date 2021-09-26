package raxcl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

//新增可视化界面，让工具使用更加便捷
public class ViewReplace extends JFrame implements ActionListener {
    JFrame mainframe;
    JPanel panel;
    //输入需求内容
    JLabel inputNeed = new JLabel("请输入需求代码：");
    JTextArea inputNeedTxt = new JTextArea();
    //执行脚本按钮
    JButton startButton = new JButton("点我开始生成！");
    //成功信息
    JLabel successTip = new JLabel("生成功能，本程序即将销毁");
    //关闭功能
    boolean closeFlag=false;
    Timer timer = new Timer(100,this);


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
        successTip.setVisible(false);
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
        //成功提示信息
        successTip.setBounds(10,380,200,50);
        successTip.setFont(new Font("微软雅黑", Font.BOLD,14));
        successTip.setForeground(Color.red);
        this.panel.add(successTip);
        //增加动作监听
        startButton.addActionListener(this);

    }

    //单击动作触发方法
    @Override
    public void actionPerformed(ActionEvent event) {
        if (closeFlag){
            System.out.println("本程序将在三秒后关闭");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
        if (event.getSource() == startButton){
            successTip.setVisible(true);
            closeFlag=true;
            //执行多语言生成方法
            MoreLanguage moreLanguage = new MoreLanguage();
            moreLanguage.buildMoreLanguage(inputNeedTxt.getText());
        }
        timer.start();
    }

    public static void main(String[] args) {
        ViewReplace viewReplace = new ViewReplace();
        viewReplace.viewWin();
    }

}
