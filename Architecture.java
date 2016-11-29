package javaapplication27;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.*;
import java.awt.Component.*;
import java.awt.event.*;
import java.io.*;

class MipsFrame extends JFrame {

    private boolean flagbranch = false;
    private boolean passedbybeq = false;
    int beqnum;
    int jumptemp;
    int requiredmemoryvalue = 0;
    private int[] MemoryValues = new int[5000];
    private static int indexx;
    private ArrayList<Integer> addressarray = new ArrayList<Integer>();
    private ArrayList<String> stringarray = new ArrayList<String>();
    private int rd = 0;
    private int rs = 0;
    private int rt = 0;
    int op;
    boolean regdst;
    private boolean j;
    private int immed = 0;
    private String[] arr;
    private boolean brunch;
    private boolean flag;
    private boolean flag1;
    private boolean flag2 = false;
    private boolean flag3;
    private boolean flag4;
    private boolean flag5;
    private boolean flag6;
    private boolean flag7;
    private boolean flag8;
    private boolean flag9;
    private boolean flag10;
    private boolean flag11;
    private boolean flag12;
    private boolean flag13;
    private boolean flag14;
    private boolean flag15;
    private boolean flag16;
    private boolean flag17;
    private boolean flag18;
    private boolean flag19;
    private boolean stl;
    private boolean stli;
    private boolean srl;
    private boolean flaglw;
    private String fullinstructioncode;//take it from fetching combining all of them
    private String immed2;
    private int address;
    private String pcp4;
    private String BranchAddress;
    private String JumpAddress;
    private boolean sw;
    private boolean ori;
    private boolean or;
    private boolean and;
    private boolean andi;
    private boolean sub;
    private boolean sll;
    private boolean jal;
    private boolean mul;
    private boolean nor;
    private boolean stlu;
    private boolean stlui;
    private int func;
    private int offset;
    private boolean addi;
    private boolean beq;
    private boolean bne;
    private boolean flag20;
    private boolean flagbne;
    private int ra;
    private boolean jr;
    private boolean flag0;
    private int shamt = 0;
    private boolean memwrite = false;
    private boolean memread = false;
    private boolean regwrite = false;
    private boolean Aluscr = false;
    private boolean Aluop = false;
    private int pc = 0;
    private boolean memtoreg = false;
    private boolean regtomem = false;
    private boolean add;
    private boolean lw = true;
    private JTextArea x;
    private JButton translate;
    private JTextArea user;
    private JLabel output;
    private JLabel number;
    private JTextArea num;
    private JButton confirmnum;
    private JPanel up;
    private JPanel center;
    private JLabel instruct;
    public JTextArea instructions;
    private JLabel DataPathIMG;
    private JLabel DataPath;
    private JPanel cup;
    private JPanel coc;
    private String inst = "j";
    private String result;
    private int beginingaddress;
    private String input;
    private JButton confirminst;
    private Font fbtn = new Font(Font.SERIF, 10, 20);
    private Font flabels = new Font(Font.SERIF, 10, 25);
    private Font ftxts = new Font(Font.SANS_SERIF, 10, 23);
    private JPanel in;
    private String currentinst = "";
    public String cfrminstruct = "";
    public String one = "";
    public String two = "";
    public String three = "";
    public String four = "";
    public String five = "";
    public String six = "";
    public String seven = "";
    public String eight = "";
    public String nine = "";
    public String ten;
    public String eleven = "";
    public JPanel leftcenter;
    private JLabel numbques;
    private JTextArea numb;
    private JButton cfrmnumbtn;
    String str;
    private JPanel downup;
    private JPanel upup;
    private int noOfInstructions;
    private String[] instructionline;
    private String textareatext;
    private String[] splitarea;
    private static int determine = 0;
    private String jumpbinary;
    private boolean branchresult = true;
    public javax.swing.Timer timer;

    public javax.swing.Timer timer2;
    private int rareg;
    String fffff = "";

    private JScrollBar scrol;
    private JScrollBar scroll;
    private JPanel temp;
    private JPanel temp2;
    private JScrollPane scrolp;
    private JScrollPane scrollp;

    boolean add1;
    boolean addi1;
    boolean sub1;
    boolean lw1;
    boolean sw1;
    boolean and1;
    boolean sll1;
    boolean or1;
    boolean nor1;
    boolean beq1;
    boolean bne1;
    boolean j1;
    boolean jal1;
    boolean jr1;
    boolean slt1;
    boolean slti1;
    boolean sltu1;
    boolean sltui1;
    boolean andi1;
    boolean mul1;
    boolean srl1;
    String current = "";
    static int[] res = new int[32];
    String c = "";
    static int f = 0;
    int addr;
    String lwswresult = "";
    int r;

    public MipsFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(1500, 1000);
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());
        up();
        c.add(up, BorderLayout.NORTH);
        center();
        c.add(center, BorderLayout.CENTER);
    }

    public void DataMemorystore() {

        int value = res[rt];
        MemoryValues[addr] = value;
        lwswresult = "The value saved in the memory is :" + value + "in place" + addr;

    }

    public void DataMemoryload() {
        requiredmemoryvalue = MemoryValues[addr];

        res[rs] = requiredmemoryvalue;
        lwswresult = "The result saved in the destination register " + requiredmemoryvalue + "on place " + addr + "in memory";
        //elregister elhnload feeh hyb2a hwa elfo2eena 

    }

    public void ALUcontrol() {
        //lw=false;
        //instfetc();
        add1 = false;
        addi1 = false;
        sub1 = false;
        lw1 = false;
        sw1 = false;
        and1 = false;
        sll1 = false;
        or1 = false;
        nor1 = false;
        beq1 = false;
        bne1 = false;
        slt1 = false;
        slti1 = false;
        sltu1 = false;
        sltui1 = false;
        andi1 = false;
        mul1 = false;
        srl1 = false;
        j = false;
        jr = false;
        jal = false;
        lwswresult = "";
        if (op == 000000) {
            if (func == 100000) {
                System.out.println(rs + " " + rt + " " + rd);
                System.out.println("ressss= " + res[rd] + " " + res[rs] + " " + res[rt]);
                res[rd] = res[rs] + res[rt];
                add1 = true;
                c = res[rd] + "";
                System.out.println("result = " + res[rd]);

            } else if (func == 100010) {
                System.out.println(rs + " " + rt + " " + rd);
                res[rd] = res[rs] - res[rt];
                sub1 = true;
                c = res[rd] + "";
                System.out.println("result = " + res[rd]);

            } else if (func == 011000) {
                System.out.println(rs + " " + rt + " " + rd);
                res[rd] = res[rs] * res[rt];
                mul1 = true;
                c = res[rd] + "";
                System.out.println("result = " + res[rd]);
            } else if (func == 100100) {
                System.out.println(rs + " " + rt + " " + rd);
                String x = toBinary(res[rs]);
                String y = toBinary(res[rt]);
                int size1 = x.length();
                int size2 = y.length();
                for (int i = 1; size1 < 32; i++) {
                    x = "0" + x;
                    size1++;
                }
                for (int i = 1; size2 < 32; i++) {
                    y = "0" + y;
                    size2++;
                }
                System.out.println(x);
                System.out.println(y);
                String g = "";
                for (int i = 0; i < 32; i++) {
                    if (x.charAt(i) == y.charAt(i)) {
                        g = g + x.charAt(i);
                    } else {
                        g = g + "0";
                    }
                }
                res[rd] = Integer.parseInt(g, 2);
                c = res[rd] + "";
                System.out.println("result = " + res[rd]);
                and1 = true;
            } else if (func == 000000) {
                res[rd] = res[rs] * (int) Math.pow(2, immed);
                c = res[rd] + "";
                System.out.println("result = " + res[rd]);
                sll1 = true;
            } else if (func == 100101) {
                System.out.println(rs + " " + rt + " " + rd);
                String x = toBinary(res[rs]);
                String y = toBinary(res[rt]);
                int size1 = x.length();
                int size2 = y.length();
                for (int i = 1; size1 < 32; i++) {
                    x = "0" + x;
                    size1++;
                }
                for (int i = 1; size2 < 32; i++) {
                    y = "0" + y;
                    size2++;
                }
                System.out.println(x);
                System.out.println(y);
                String g = "";
                for (int i = 0; i < 32; i++) {
                    if (x.charAt(i) == '1' || y.charAt(i) == '1') {
                        g = g + "1";
                    } else {
                        g = g + "0";
                    }
                }
                res[rd] = Integer.parseInt(g, 2);
                c = res[rd] + "";
                System.out.println("result = " + res[rd]);
                or1 = true;
            } else if (func == 100111) {
                System.out.println(rs + " " + rt + " " + rd);
                String x = toBinary(res[rs]);
                String y = toBinary(res[rt]);
                int size1 = x.length();
                int size2 = y.length();
                int q;
                if (size1 < size2) {
                    q = size2;
                } else {
                    q = size1;
                }
                for (int i = 1; size1 < q; i++) {
                    x = "0" + x;
                    size1++;
                }
                for (int i = 1; size2 < q; i++) {
                    y = "0" + y;
                    size2++;
                }
                System.out.println(x);
                System.out.println(y);
                String g = "";
                for (int i = 0; i < q; i++) {
                    if (x.charAt(i) == '0' && y.charAt(i) == '0') {
                        g = g + "1";
                    } else {
                        g = g + "0";
                    }
                }
                res[rd] = Integer.parseInt(g, 2);
                c = res[rd] + "";
                System.out.println("result = " + res[rd]);
                nor1 = true;
            } else if (func == 101010) {
                if (res[rs] - res[rt] < 0) {
                    res[rd] = 1;
                    slt1 = true;
                } else {
                    res[rd] = 0;
                    slt1 = false;
                }
                c = res[rd] + "";
            } else if (func == 101011) {
                System.out.println(rs + " " + rt + " " + rd);
                String x = toBinary(res[rs]);
                String y = toBinary(res[rt]);
                int size1 = x.length();
                int size2 = y.length();
                int q;
                if (size1 < size2) {
                    q = size2;
                } else {
                    q = size1;
                }
                for (int i = 1; size1 < q; i++) {
                    x = "0" + x;
                    size1++;
                }
                for (int i = 1; size2 < q; i++) {
                    y = "0" + y;
                    size2++;
                }
                System.out.println(x);
                System.out.println(y);
                String g = "";
                for (int i = 0; i < q; i++) {
                    if (x.charAt(i) < y.charAt(i)) {
                        res[rd] = 1;
                        break;
                    } else {
                        res[rd] = 0;
                    }
                }
                //res[rd] = Integer.parseInt(g, 2);
                c = res[rd] + "";
                System.out.println("result = " + res[rd]);
                sltu1 = true;
            } else if (func == 000010) {
                res[rd] = res[rs] / (int) Math.pow(2, immed);
                c = res[rd] + "";
                System.out.println("result = " + res[rd]);
                srl1 = true;
            }
        } else if (op == 001000) {
            System.out.println(rs + " " + rt + " " + rd);
            System.out.println(immed);
            System.out.println(res[0]);
            res[rt] = res[rs] + immed;
            c = res[rt] + "";
            System.out.println("result = " + res[rt]);
            addi1 = true;
            //System.out.println(res[rd]);
        } else if (op == 100011) {
            addr = (res[rs] + offset) / 4;
            System.out.println("address= " + addr);
            lw1 = true;

            DataMemoryload();
        } else if (op == 101011) {
            addr = (res[rs] + offset) / 4;
            System.out.println("address= " + addr);
            sw1 = true;
            DataMemorystore();
        } else if (op == 000100) {
            if (res[rs] - res[rt] == 0) {
                branchresult = true;
                beq1 = true;

            } else {
                branchresult = false;
            }
        } else if (op == 000101) {
            if (res[rs] - res[rt] != 0) {
                branchresult = true;
                bne1 = true;
            } else {
                branchresult = false;
            }
        } else if (op == 001010) {
            if (res[rs] - immed < 0) {
                res[rd] = 1;
                slti1 = true;
            } else {
                res[rd] = 0;
                slti1 = false;
            }
            c = res[rd] + "";
            System.out.println("result = " + res[rd]);
        } else if (op == 010001) {
            System.out.println(rs + " " + rt + " " + rd);
            String x = toBinary(res[rs]);
            String y = toBinary(immed);
            int size1 = x.length();
            int size2 = y.length();
            int q;
            if (size1 < size2) {
                q = size2;
            } else {
                q = size1;
            }
            for (int i = 1; size1 < q; i++) {
                x = "0" + x;
                size1++;
            }
            for (int i = 1; size2 < q; i++) {
                y = "0" + y;
                size2++;
            }
            System.out.println(x);
            System.out.println(y);
            String g = "";
            for (int i = 0; i < q; i++) {
                if (x.charAt(i) < y.charAt(i)) {
                    res[rt] = 1;
                    break;
                } else {
                    res[rt] = 0;
                }
            }
            //res[rd] = Integer.parseInt(g, 2);
            c = res[rt] + "";
            System.out.println("result = " + res[rt]);
            sltui1 = true;
        } else if (op == 001100) {
            System.out.println(rs + " " + rt + " " + rd);
            String x = toBinary(res[rs]);
            String y = toBinary(immed);
            int size1 = x.length();
            int size2 = y.length();
            for (int i = 1; size1 < 32; i++) {
                x = "0" + x;
                size1++;
            }
            for (int i = 1; size2 < 32; i++) {
                y = "0" + y;
                size2++;
            }
            System.out.println(x);
            System.out.println(y);
            String g = "";
            for (int i = 0; i < 32; i++) {
                if (x.charAt(i) == y.charAt(i)) {
                    g = g + x.charAt(i);
                } else {
                    g = g + "0";
                }
            }
            res[rd] = Integer.parseInt(g, 2);
            c = res[rd] + "";
            System.out.println("result = " + res[rd]);
            andi1 = true;
        }
        fffff = "add= " + add1 + "\\ addi= " + addi1 + "\\ sub= " + sub1 + "\n" + "\\ lw= " + lw1 + "\\ sw= " + sw1 + "\\ and= " + and1 + "\n"
                + "\\ sll= " + sll1 + "\\ or= " + or1 + "\\ nor= " + nor1 + "\n" + "\\ beq= " + beq1 + "\\ bne= " + bne1 + "\\ j= " + j + "\n" + "\\ jal=" + jal
                + "\\ jr= " + jr + "\\ slt= " + slt1 + "\n" + "\\ slti= " + slti1 + "\\ sltu= " + sltu1 + "\\ sltui= " + sltui1 + "\\ srl= " + srl1 + "\n" + c;
    }

    public int getsizestring(String p) {
        int r = 0;
        char[] s = p.toCharArray();
        for (int z = 0; z < s.length; z++) {
            r++;
        }
        return r;
    }

    public int getoffsetindex(String g) {
        int i = 0;
        char[] c = g.toCharArray();
        for (int j = 0; c[j] != '('; j++) {
            i++;
        }
        return i;
    }

    public int writeback(String b) {
        int f = Integer.parseInt(b);
        return f;
    }

    public int getaddress(String a) {
        int d = Integer.parseInt(a);
        return d;
    }

    public int getregister(String x) {
        int r = 0;
        if (x.equals("$s1")) {
            r = 17;//$s1=17
//System.out.println("$s1");
            return r;
        } else if (x.equals("$s0")) {
            r = 16;//s0=16
//System.out.println("$s0");
            return r;
        } else if (x.equals("$at")) {
            r = 1;
            return r;
//System.out.println("$gp");
        } else if (x.equals("$s2")) {
            r = 18;
            return r;
//System.out.println("$s2");
        } else if (x.equals("$s3")) {
            r = 19;
            return r;
//System.out.println("$s3");
        } else if (x.equals("$s4")) {
            r = 20;
            return r;
//System.out.println("$s4");
        } else if (x.equals("$5")) {
            r = 21;
            return r;
//System.out.println("$s5");
        } else if (x.equals("$s6")) {
            r = 22;
            return r;
//System.out.println("$s6");
        } else if (x.equals("$s7")) {
            r = 23;
            return r;
//System.out.println("$s7");
        } else if (x.equals("$t0")) {
            r = 8;
            return r;
//System.out.println("$t0");
        } else if (x.equals("$t1")) {
            r = 9;
            return r;
//System.out.println("$t1");
        } else if (x.equals("$t2")) {
            r = 10;
            return r;
//System.out.println("$t2");
        } else if (x.equals("$t3")) {
            r = 11;
            return r;
//System.out.println("$t3");
        } else if (x.equals("$t4")) {
            r = 12;
            return r;
//System.out.println("$t4");
        } else if (x.equals("$t5")) {
            r = 13;
            return r;
//System.out.println("$t5");
        } else if (x.equals("$t6")) {
            r = 14;
            return r;
//System.out.println("$t6");
        } else if (x.equals("$t7")) {
            r = 15;
            return r;
//System.out.println("$t7");
        } else if (x.equals("$t8")) {
            r = 24;
            return r;
//System.out.println("$t8");
        } else if (x.equals("$t9")) {
            r = 25;
            return r;
//System.out.println("$t9");
        } else if (x.equals("$a0")) {
            r = 4;
            return r;
//System.out.println("$a0");
        } else if (x.equals("$a1")) {
            r = 5;
            return r;
//System.out.println("$a1");
        } else if (x.equals("$a2")) {
            r = 6;
            return r;
//System.out.println("$a2");
        } else if (x.equals("$a3")) {
            r = 7;
            return r;
//System.out.println("$a3");
        } else if (x.equals("$v0")) {
            r = 2;
            return r;
//System.out.println("$v0");
        } else if (x.equals("$v1")) {
            r = 3;
            return r;
//System.out.println("$v1");
        } else if (x.equals("$k0")) {
            r = 26;
            return r;
//System.out.println("$gp");
        } else if (x.equals("$k1")) {
            r = 27;
            return r;
//System.out.println("$gp");
        } else if (x.equals("$gp")) {
            r = 28;
            return r;
//System.out.println("$gp");
        } else if (x.equals("$sp")) {
            r = 29;
            return r;
//System.out.println("$sp");
        } else if (x.equals("$fp")) {
            r = 30;
            return r;
//System.out.println("$fp");
        } else if (x.equals("$ra")) {
            r = 31;
            return r;
//System.out.println("$ra");
        } else if (x.equals("$zero")) {
            r = 0;
//final int value =0;
            return r;
//System.out.println("$zero");
        }

        return 0;
    }
//public String regstring( int r ){
//    String[] a=new String[]{"$zero","$at","$v0","$v1","$a0","$a1","$a2","$a3","$t0","$t1","$t2","$t3","$t4","$t5","$t6","$t7","$s0","$s1","$s2","$s3",
//    "$s4","$s5","$s6","$s7","$t8","$t9","$k0","$k1","$gp","$sp","$fp","$ra"};
//   return a(r);
// }

    public void regfile(int[] res) {

        str = "$zero = " + 0 + "  =  " + 0/* Integer.toHexString(res[0])*/ + "\n" + "$at = " + res[1] + "  =  " + Integer.toHexString(res[1]) + "\n"
                + "$v0 = " + res[2] + "  =  " + Integer.toHexString(res[2]) + "\n" + "$v1 = " + res[3] + "  =  " + Integer.toHexString(res[3]) + "\n" + "$a0 = " + res[4] + "  =  " + Integer.toHexString(res[4]) + "\n"
                + "$a1 = " + res[5] + "  =  " + Integer.toHexString(res[5]) + "\n" + "$a2 = " + res[6] + "  =  " + Integer.toHexString(res[6]) + "\n"
                + "$a3 = " + res[7] + "  =  " + Integer.toHexString(res[7]) + "\n" + "$t0 = " + res[8] + "  =  " + Integer.toHexString(res[8]) + "\n" + "$t1 = " + res[9] + "  =  " + Integer.toHexString(res[9]) + "\n"
                + "$t2 = " + res[10] + "  =  " + Integer.toHexString(res[10]) + "\n" + "$t3 = " + res[11] + "  =  " + Integer.toHexString(res[11]) + "\n"
                + "$t4 = " + res[12] + "  =  " + Integer.toHexString(res[12]) + "\n" + "$t5 = " + res[13] + "  =  " + Integer.toHexString(res[13]) + "\n" + "$t6 = " + res[14] + "  =  " + Integer.toHexString(res[14]) + "\n"
                + "$t7 = " + res[15] + "  =  " + Integer.toHexString(res[15]) + "\n" + "$s0 = " + res[16] + "  =  " + Integer.toHexString(res[16]) + "\n"
                + "$s1 = " + res[17] + "  =  " + Integer.toHexString(res[17]) + "\n" + "$s2 = " + res[18] + "  =  " + Integer.toHexString(res[18]) + "\n" + "$s3 = " + res[19] + "  =  " + Integer.toHexString(res[19]) + "\n"
                + "$s4 = " + res[20] + "  =  " + Integer.toHexString(res[20]) + "\n" + "$s5 = " + res[21] + "  =  " + Integer.toHexString(res[21]) + "\n"
                + "$s6 = " + res[22] + "  =  " + Integer.toHexString(res[22]) + "\n" + "$s7 = " + res[23] + "  =  " + Integer.toHexString(res[23]) + "\n" + "$t8 = " + res[24] + "  =  " + Integer.toHexString(res[24]) + "\n"
                + "$t9 = " + res[25] + "  =  " + Integer.toHexString(res[25]) + "\n" + "$k0 = " + res[26] + "  =  " + Integer.toHexString(res[26]) + "\n"
                + "$k1 = " + res[27] + "  =  " + Integer.toHexString(res[27]) + "\n" + "$gp = " + res[28] + "  =  " + Integer.toHexString(res[28]) + "\n" + "$sp = " + res[29] + "  =  " + Integer.toHexString(res[29]) + "\n"
                + "$fp = " + res[30] + "  =  " + Integer.toHexString(res[30]) + "\n" + "$ra = " + res[31] + "  =  " + Integer.toHexString(res[31]);
    }

    public String getinst(int i) {
        return stringarray.get(i);
    }//get instruction to jump to it

    public boolean isreg(String y) {
        if (y.equals("$s1")) {
            return true;
        } else if (y.equals("$s0")) {
            return true;
        } else if (y.equals("$s2")) {
            return true;
        } else if (y.equals("$zero")) {
            return true;
        }
        return false;
    }

    public boolean isdigit(String a) {
        for (int i = 0; i < a.length(); i++) {
            if (Character.isDigit(a.charAt(i))) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void instfetc() {
        arr = cfrminstruct.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("add")) {
                currentinst = "add";
                System.out.println("add");
                one = "add";
                op = 000000;
                regdst = true;
                regwrite = true;
                j = false;
                brunch = false;
                jal = false;
                jr = false;
                bne = false;
                memtoreg = false;
                memread = false;
                Aluscr = false;
                Aluop = true;
                System.out.println("Control signals are : Regdst: " + regdst + " j: " + j
                        + "\n jal: " + jr + " bne " + bne + "Memtoreg: " + memtoreg
                        + "\n Memread: " + memread + " Aluop: " + Aluop + "   d");
                two = "Control signals are : Regdst" + regdst + " j " + j
                        + "\n jal " + jr + " bne" + bne + "Remtoreg " + memtoreg
                        + "\nMemread " + memread + " Aluop " + Aluop;
                func = 100000;
                flag1 = true;
                add = true;
                or = false;
                flaglw = false;
                lw = false;
            } else if (flag1 == true && add == true) {

                rd = getregister(arr[i]);
                flag1 = false;

            } else if (flag1 == false && add == true) {

                rs = getregister(arr[i]);
                flag1 = true;
                add = false;

            } else if (flag1 == true && add == false) {

                rt = getregister(arr[i]);
                regdst = true;
                add = false;
                flag1 = false;

            }
            if (arr[i].equals("j")) {
                currentinst = "j";
                System.out.println("j");
                one = "j";
                flag = true;
                op = 000010;
                regdst = false;
                regwrite = false;
                j = true;
                brunch = false;
                jal = false;
                jr = false;
                bne = false;
                memtoreg = false;
                memread = false;
                Aluscr = false;
                Aluop = false;
                memwrite = false;
                System.out.println("Control signals are : Regdst" + regdst + "\n j "
                        + j + "\n jal " + jr + "\n bne" + bne + "\n Memtoreg " + memtoreg
                        + "\n Memread " + memread + " \n Aluop " + Aluop
                        + "\n Memwrite " + memwrite);
                two = "Control signals are : Regdst" + regdst + "\n j "
                        + j + "\n jal " + jr + "\n bne" + bne + "\n Memtoreg " + memtoreg
                        + "\n Memread " + memread + " \n Aluop " + Aluop
                        + "\n Memwrite " + memwrite;
            } else if (flag) {
                if (isdigit(arr[i])) {
                    immed = getaddress(arr[i]);
                    System.out.println("" + immed);
                    flag = false;
                }
            } else if (arr[i].equals("lw")) {
                currentinst = "lw";
                System.out.println("lw");
                one = "lw";
                op = 100011;
                lw = true;
                flaglw = false;
                regdst = false;
                regwrite = true;
                j = false;
                brunch = false;
                jal = false;
                jr = false;
                bne = false;
                memtoreg = true;
                memread = true;
                memwrite = false;
                Aluscr = true;
                Aluop = false;
                System.out.println("control signals is : regdst" + regdst + "\n j " + j + "\n jal " + jr + "\n bne" + bne + "\n memtoreg " + memtoreg + "\n memread " + memread + "\n Aluop " + Aluop + "\n memwrite " + memwrite);
                two = "control signals is : regdst" + regdst + "\n j " + j + "\n jal " + jr + "\n bne" + bne + "\n memtoreg " + memtoreg + "\n memread " + memread + "\n Aluop " + Aluop + "\n memwrite " + memwrite;
            } else if (lw == true && flaglw == false) {
                if (isreg(arr[i])) {
                    rt = getregister(arr[i]);
                    regdst = true;
                    lw = false;
                    flaglw = true;
                }
            } else if (lw == false && flaglw == true) {
                if (isreg(arr[i]) == false) {
                    int j = getoffsetindex(arr[i]);
                    int k = getsizestring(arr[i]);
                    String c = arr[i].substring(0, j);
                    String d = arr[i].substring(j + 1, 5);
                    offset = getaddress(c);
                    System.out.println("the offset is " + offset);
                    three = "the offset is " + offset;
                    rs = getregister(d);
                    flaglw = false;
                    lw = false;
                }
            }
            if (arr[i].equals("or")) {
                currentinst = "or";
                System.out.println("or");
                one = "or";
                or = true;
                flag2 = true;
                add = false;
                flaglw = false;
                lw = false;
                op = 000000;
                func = 100101;
                regdst = true;
                regwrite = true;
                j = false;
                brunch = false;
                jal = false;
                jr = false;
                bne = false;
                memtoreg = false;
                memread = false;
                Aluscr = false;
                Aluop = true;
                System.out.println("control signals is : regdst" + regdst
                        + " j " + j + " jal " + jr + " bne" + bne + "memtoreg " + memtoreg
                        + "memread " + memread + " Aluop " + Aluop);
                two = "Control signals are : regdst" + regdst
                        + "\n j " + j + " jal " + jr + " bne" + bne + "\nmemtoreg " + memtoreg
                        + "memread " + memread + " Aluop " + Aluop;
            } else if (flag2 == true && or == true) {
                rd = getregister(arr[i]);
                flag2 = false;
            } else if (flag2 == false && or == true) {
                rs = getregister(arr[i]);
                flag2 = true;
            } else if (flag2 == true && or == true) {
                rt = getregister(arr[i]);
                flag2 = false;
                or = false;
            } else if (arr[i].equals("sub")) {
                currentinst = "sub";
                System.out.println("sub");
                one = "sub";
                sub = false;
                flag3 = true;
                add = false;
                or = false;
                flaglw = false;
                lw = false;

                op = 000000;
                func = 100010;
                regdst = true;
                regwrite = true;
                j = false;
                brunch = false;
                jal = false;
                jr = false;
                bne = false;
                memtoreg = false;
                memread = false;
                Aluscr = false;
                Aluop = true;
                System.out.println("Control signals are : regdst" + regdst + " j " + j
                        + "\n jal " + jr + " bne" + bne + "memtoreg " + memtoreg
                        + "\nmemread " + memread + " Aluop " + Aluop);
                two = "Control signals are : regdst" + regdst + " j " + j
                        + "\n jal " + jr + " bne" + bne + "memtoreg " + memtoreg
                        + "\nmemread " + memread + " Aluop " + Aluop;

            } else if (flag3 == true && sub == false) {
                rd = getregister(arr[i]);
                flag3 = false;
                add = false;
                flaglw = false;
                j = false;
                flag1 = false;
                flag2 = false;
                sub = true;
            } else if (flag3 == false && sub == true) {
                rs = getregister(arr[i]);
                flag3 = true;
            } else if (flag3 == true && sub == true) {
                rt = getregister(arr[i]);
                flag3 = false;
                sub = false;
                add = false;
                lw = false;
                j = false;
                flaglw = false;
                flag1 = false;
                flag2 = false;

            } else if (arr[i].equals("mul")) {
                currentinst = "mul";
                System.out.println("mul");
                one = "mul";
                flag4 = true;
                mul = false;
                sub = false;
                add = false;
                flaglw = false;
                j = false;
                lw = false;
                op = 000000;
                func = 011000;
                regdst = true;
                regwrite = true;
                j = false;
                brunch = false;
                jal = false;
                jr = false;
                bne = false;
                memtoreg = false;
                memread = false;
                Aluscr = false;
                Aluop = true;
                System.out.println("control signals is : regdst" + regdst
                        + " j " + j + " jal " + jr + " bne" + bne + "memtoreg "
                        + memtoreg + "memread " + memread + " Aluop " + Aluop);
                two = "control signals is : regdst" + regdst
                        + "\n j " + j + " jal " + jr + " bne" + bne + "memtoreg "
                        + memtoreg + "\nmemread " + memread + "Aluop " + Aluop;

            } else if (flag4 == true && mul == false) {

                rd = getregister(arr[i]);
                flag3 = false;
                add = false;
                flaglw = false;
                j = false;
                flag1 = false;
                flag2 = false;
                sub = false;
                flag4 = false;
                mul = true;

            } else if (flag4 == false && mul == true) {

                rs = getregister(arr[i]);
                flag3 = false;
                add = false;
                flaglw = false;
                j = false;
                flag1 = false;
                flag2 = false;
                sub = false;
                flag4 = true;
                mul = true;

            } else if (flag4 == true && mul == true) {

                rt = getregister(arr[i]);
                flag3 = false;
                add = false;
                flaglw = false;
                j = false;
                flag1 = false;
                flag2 = false;
                sub = false;
                flag4 = false;
                mul = false;

            } else if (arr[i].equals("nor")) {
                currentinst = "nor";
                one = "nor";
                System.out.println("nor");
                op = 000000;
                func = 100111;
                flag4 = false;
                mul = false;
                sub = false;
                add = false;
                flaglw = false;
                j = false;
                flag = false;
                flag1 = false;
                flag2 = false;
                flag3 = false;
                flag5 = true;
                nor = false;
                lw = false;

                regdst = true;
                regwrite = true;
                j = false;
                brunch = false;
                jal = false;
                jr = false;
                bne = false;
                memtoreg = false;
                memread = false;
                Aluscr = false;
                Aluop = true;
                memwrite = false;
                System.out.println("Control signals are : regdst" + regdst + " j " + j
                        + "\n jal " + jr + " bne " + bne + "memtoreg " + memtoreg
                        + "\nmemread " + memread + " Aluop " + Aluop + "memwrite " + memwrite);
                two = "Control signals are : regdst" + regdst + " j " + j
                        + "\n jal " + jr + " bne " + bne + "memtoreg " + memtoreg
                        + "\nmemread " + memread + " Aluop " + Aluop + "memwrite " + memwrite;

            } else if (flag5 == true && nor == false) {
                rd = getregister(arr[i]);
                flag3 = false;
                add = false;
                flaglw = false;
                j = false;
                flag1 = false;
                flag2 = false;
                sub = false;
                flag4 = false;
                mul = false;
                flag5 = false;
                nor = true;
            } else if (flag5 == false && nor == true) {

                rs = getregister(arr[i]);
                flag3 = false;
                add = false;
                flaglw = false;
                j = false;
                flag1 = false;
                flag2 = false;
                sub = false;
                flag4 = false;
                mul = false;
                flag5 = true;
            } else if (flag5 == true && nor == true) {
                rt = getregister(arr[i]);
                flag3 = false;
                add = false;
                flaglw = false;
                j = false;
                flag1 = false;
                flag2 = false;
                sub = false;
                flag4 = false;
                mul = false;
                flag5 = false;
                nor = false;

            } else if (arr[i].equals("slt")) {
                currentinst = "s1t";
                System.out.println("slt");
                one = "slt";
                flag3 = false;
                add = false;
                flaglw = false;
                j = false;
                flag1 = false;
                flag2 = false;
                sub = false;
                flag4 = false;
                mul = false;
                flag5 = false;
                nor = false;
                flag = false;
                flag6 = true;
                stl = false;
                lw = false;
                op = 000000;
                func = 101010;
                regdst = true;
                regwrite = true;
                j = false;
                brunch = false;
                jal = false;
                jr = false;
                bne = false;
                memtoreg = false;
                memread = false;
                Aluscr = false;
                Aluop = true;
                memwrite = false;
                System.out.println("Control signals are : regdst " + regdst + " j " + j
                        + "\n jal " + jr + " bne " + bne + "memtoreg " + memtoreg
                        + "\nmemread " + memread + " Aluop " + Aluop + "memwrite " + memwrite);
                two = "Control signals are : regdst " + regdst + " j " + j
                        + "\n jal " + jr + " bne " + bne + "memtoreg " + memtoreg
                        + "\nmemread " + memread + " Aluop " + Aluop + "memwrite " + memwrite;

            } else if (flag6 == true && stl == false) {

                rd = getregister(arr[i]);
                flag6 = false;
                stl = true;
                lw = false;

            } else if (flag6 == false && stl == true) {

                rs = getregister(arr[i]);
                flag6 = true;
                stl = true;
                lw = false;

            } else if (flag6 == true && stl == true) {

                rt = getregister(arr[i]);
                flag6 = false;
                stl = false;
                lw = false;

            } else if (arr[i].equals("sltu")) {
                currentinst = "sltu";
                System.out.println("sltu");
                one = "sltu";
                flag3 = false;
                add = false;
                flaglw = false;
                j = false;
                flag1 = false;
                flag2 = false;
                sub = false;
                flag4 = false;
                mul = false;
                flag5 = false;
                nor = false;
                flag = false;
                flag6 = false;
                stl = false;
                lw = false;
                stlu = false;
                flag7 = true;
                op = 000000;
                func = 101011;

                regdst = true;
                regwrite = true;
                j = false;
                brunch = false;
                jal = false;
                jr = false;
                bne = false;
                memtoreg = false;
                memread = false;
                Aluscr = false;
                Aluop = true;
                memwrite = false;
                System.out.println("Control signals are : regdst" + regdst + " j " + j
                        + "\n jal " + jr + " bne" + bne + "memtoreg " + memtoreg
                        + "\nmemread " + memread + " Aluop " + Aluop + " memwrie " + memwrite);
                two = "Control signals are : regdst" + regdst + " j " + j
                        + "\n jal " + jr + " bne" + bne + "memtoreg " + memtoreg
                        + "\nmemread " + memread + " Aluop " + Aluop + " memwrie " + memwrite;

            } else if (flag7 == true && stlu == false) {

                rd = getregister(arr[i]);
                flag6 = false;
                stl = false;
                lw = false;
                flag7 = false;
                stlu = true;

            } else if (flag7 == false && stlu == true) {

                rs = getregister(arr[i]);
                flag6 = false;
                stl = false;
                lw = false;
                flag7 = true;
            } else if (flag7 == true && stlu == true) {

                rt = getregister(arr[i]);
                flag6 = false;
                stl = false;
                lw = false;
                flag7 = false;
                stlu = false;

            } else if (arr[i].equals("srl")) {
                currentinst = "srl";
                System.out.println("srl");
                one = "srl";
                flag3 = false;
                add = false;
                flaglw = false;
                j = false;
                flag1 = false;
                flag2 = false;
                sub = false;
                flag4 = false;
                mul = false;
                flag5 = false;
                nor = false;
                flag = false;
                flag6 = false;
                stl = false;
                lw = false;
                stlu = false;
                flag7 = false;
                srl = false;
                flag8 = true;
                op = 00000;
                func = 000010;
                regdst = true;
                regwrite = true;
                j = false;
                brunch = false;
                jal = false;
                jr = false;
                bne = false;
                memtoreg = false;
                memread = false;
                Aluscr = false;
                Aluop = true;
                System.out.println("Control signals are : regdst" + regdst
                        + "\nj " + j + " jal " + jr + " bne" + bne + "memtoreg " + memtoreg
                        + "\nmemread " + memread + " Aluop " + Aluop);
                two = "Control signals are : regdst" + regdst
                        + "\nj " + j + " jal " + jr + " bne" + bne + "memtoreg " + memtoreg
                        + "\nmemread " + memread + " Aluop " + Aluop;

            } else if (flag8 == true && srl == false) {

                rd = getregister(arr[i]);
                flag6 = false;
                stl = false;
                lw = false;
                flag7 = false;
                stlu = false;
                flag8 = false;
                srl = true;

            } else if (flag8 == false && srl == true) {

                rs = getregister(arr[i]);
                flag6 = false;
                stl = false;
                lw = false;
                flag7 = false;
                stlu = false;
                flag8 = true;

            } else if (flag8 == true && srl == true) {
                immed = getaddress(arr[i]);
                System.out.println("" + immed);
                flag8 = false;
                srl = false;
            } else if (arr[i].equals("and")) {
                currentinst = "and";
                one = "and";
                op = 000000;
                func = 100100;
                flag3 = false;
                add = false;
                flaglw = false;
                j = false;
                flag1 = false;
                flag2 = false;
                sub = false;
                flag4 = false;
                mul = false;
                flag5 = false;
                nor = false;
                flag = false;
                flag6 = false;
                stl = false;
                lw = false;
                stlu = false;
                flag7 = false;
                srl = false;
                flag8 = false;
                System.out.println("and");
                one = "and";
                flag9 = true;
                and = false;
                regdst = true;
                regwrite = true;
                j = false;
                brunch = false;
                jal = false;
                jr = false;
                bne = false;
                memtoreg = false;
                memread = false;
                Aluscr = false;
                Aluop = true;
                memwrite = false;
                System.out.println("control signals is : regdst" + regdst + " j " + j
                        + "\njal " + jr + " bne" + bne + "memtoreg " + memtoreg
                        + "memread " + memread + " Aluop " + Aluop + "\n memwrite " + memwrite);
                two = "control signals is : regdst" + regdst + " j " + j
                        + "\njal " + jr + " bne" + bne + "memtoreg " + memtoreg
                        + "memread " + memread + " Aluop " + Aluop + "\n memwrite " + memwrite;

            } else if (flag9 == true && and == false) {
                rd = getregister(arr[i]);
                flag6 = false;
                stl = false;
                lw = false;
                flag7 = false;
                stlu = false;
                flag8 = false;
                flag9 = false;
                and = true;
            } else if (flag9 == false && and == true) {
                rs = getregister(arr[i]);
                flag6 = false;
                stl = false;
                lw = false;
                flag7 = false;
                stlu = false;
                flag8 = false;
                flag9 = true;
            } else if (flag9 == true && and == true) {
                rt = getregister(arr[i]);
                flag6 = false;
                stl = false;
                lw = false;
                flag7 = false;
                stlu = false;
                flag8 = false;
                flag9 = false;
                and = false;

            } else if (arr[i].equals("sll")) {
                currentinst = "sll";
                System.out.println("sll");
                one = "sll";
                op = 00000;
                func = 000000;
                flag9 = false;
                and = false;
                flag10 = true;
                sll = false;
                lw = false;
                regdst = true;
                regwrite = true;
                j = false;
                brunch = false;
                jal = false;
                jr = false;
                bne = false;
                memtoreg = false;
                memread = false;
                Aluscr = false;
                Aluop = true;
                memwrite = false;
                System.out.println("control signals is : regdst" + regdst + " j " + j
                        + " jal " + jr + " bne" + bne + "memtoreg " + memtoreg
                        + "memread " + memread + " Aluop " + Aluop + " memwrite" + memwrite);
                two = "control signals is : regdst" + regdst + " j " + j
                        + " jal " + jr + " bne" + bne + "memtoreg " + memtoreg
                        + "memread " + memread + " Aluop " + Aluop + " memwrite" + memwrite;

            } else if (flag10 == true && sll == false) {
                rd = getregister(arr[i]);
                flag6 = false;
                stl = false;
                lw = false;
                flag7 = false;
                stlu = false;
                flag8 = false;
                srl = false;
                flag10 = false;
                sll = true;

            } else if (flag10 == false && sll == true) {

                rs = getregister(arr[i]);
                flag6 = false;
                stl = false;
                lw = false;
                flag7 = false;
                stlu = false;
                flag8 = false;
                srl = false;
                flag10 = true;

            } else if (flag10 == true && sll == true) {

                immed = getaddress(arr[i]);
                System.out.println("" + immed);
                three = "" + immed;
                flag8 = false;
                srl = false;
                flag10 = false;
                srl = false;
                lw = false;
                flaglw = false;
                add = false;

            } else if (arr[i].equals("addi")) {
                currentinst = "addi";
                System.out.println("addi");
                one = "addi";
                lw = false;
                flag11 = true;
                addi = false;
                op = 001000;

                regdst = false;
                regwrite = true;
                j = false;
                brunch = false;
                jal = false;
                jr = false;
                bne = false;
                memtoreg = false;
                memread = false;
                Aluscr = true;
                Aluop = true;
                memwrite = false;
                System.out.println("control signals is : regdst" + regdst
                        + "\n j " + j + " jal " + jr + " bne" + bne + "memtoreg " + memtoreg
                        + "\nmemread " + memread + " Aluop " + Aluop + " memwrite " + memwrite);
                two = "control signals is : regdst" + regdst
                        + "\n j " + j + " jal " + jr + " bne" + bne + "memtoreg " + memtoreg
                        + "\nmemread " + memread + " Aluop " + Aluop + " memwrite " + memwrite;

// regwrite=true;
            } else if (flag11 == true && addi == false) {
                rt = getregister(arr[i]);
                flag6 = false;
                stl = false;
                lw = false;
                flag7 = false;
                stlu = false;
                flag8 = false;
                srl = false;
                flag10 = false;
                sll = false;
                addi = true;
                flag11 = false;

            } else if (flag11 == false && addi == true) {

                rs = getregister(arr[i]);
                lw = false;
                flag10 = false;
                addi = true;
                flag11 = true;

            } else if (flag11 == true && addi == true) {

                immed = getaddress(arr[i]);
                System.out.println("" + immed);
                flag8 = false;
                srl = false;
                flag11 = false;
                addi = false;
                lw = false;

            } else if (arr[i].equals("andi")) {
                currentinst = "andi";
                System.out.println("andi");
                one = "andi";
                lw = false;
                flag12 = true;
                andi = false;
                op = 001100;
                regdst = false;
                regwrite = true;
                j = false;
                brunch = false;
                jal = false;
                jr = false;
                bne = false;
                memtoreg = false;
                memread = false;
                Aluscr = true;
                Aluop = true;
                memwrite = false;
                System.out.println("control signals is : regdst" + regdst + " j " + j
                        + "\n jal " + jr + " bne" + bne + " memtoreg " + memtoreg
                        + "\nmemread " + memread + " Aluop " + Aluop + " memwrite " + memwrite);
                two = "control signals is : regdst" + regdst + " j " + j
                        + "\n jal " + jr + " bne" + bne + " memtoreg " + memtoreg
                        + "\nmemread " + memread + " Aluop " + Aluop + " memwrite " + memwrite;

//regdst=false;
            } else if (flag12 == true && andi == false) {

                rt = getregister(arr[i]);
                lw = false;
                flag10 = false;
                addi = false;
                flag11 = false;
                flag12 = false;
                andi = true;

            } else if (flag12 == false && andi == true) {

                rs = getregister(arr[i]);
                lw = false;
                flag10 = false;
                addi = false;
                flag11 = false;
                flag12 = true;
                andi = true;

            } else if (flag12 == true && andi == true) {

                immed = getaddress(arr[i]);
                System.out.println("immediate: " + immed);
                two = "immediate: " + immed;
                lw = false;
                flag12 = false;
                andi = false;

            } else if (arr[i].equals("ori")) {
                currentinst = "ori";
                one = "ori";
                op = 00000;
//regdst=false;
                lw = false;
                flag10 = false;
                addi = false;
                flag11 = false;
                flag12 = false;
                andi = false;
                ori = false;
                flag13 = true;

                regdst = false;
                regwrite = true;
                j = false;
                brunch = false;
                jal = false;
                jr = false;
                bne = false;
                memtoreg = false;
                memread = false;
                Aluscr = true;
                Aluop = true;
                memwrite = false;
                System.out.println("Control signals are : regdst" + regdst + " j " + j
                        + "\n jal " + jr + " bne" + bne + " memtoreg " + memtoreg
                        + "\n memread " + memread + " Aluop " + Aluop + " memwrite " + memwrite);
                two = "Control signals are : regdst" + regdst + " j " + j
                        + "\n jal " + jr + " bne" + bne + " memtoreg " + memtoreg
                        + "\n memread " + memread + " Aluop " + Aluop + " memwrite " + memwrite;

            } else if (flag13 == true && ori == false) {

                rt = getregister(arr[i]);
                lw = false;
                ori = true;
                flag13 = false;

            } else if (flag13 == false && ori == true) {

                rs = getregister(arr[i]);
                lw = false;
                flag13 = true;
                ori = true;

            } else if (flag13 == true && ori == true) {

                immed = getaddress(arr[i]);
                System.out.println("immediate: " + immed);
                two = "immediate: " + immed;
                lw = false;
                flag13 = false;
                ori = false;

            } else if (arr[i].equals("slti")) {
                currentinst = "slti";
                System.out.println("slti");
                one = "slti";
                lw = false;
                op = 001010;
//regdst=false;
                flag14 = true;
                stli = false;
                regdst = false;
                regwrite = true;
                j = false;
                brunch = false;
                jal = false;
                jr = false;
                bne = false;
                memtoreg = false;
                memread = false;
                Aluscr = true;
                Aluop = true;
                memwrite = false;
                System.out.println("control signals is : regdst" + regdst
                        + "\nj " + j + " jal " + jr + " bne" + bne + " memtoreg " + memtoreg
                        + "\n memread " + memread + " Aluop " + Aluop + " memwrite" + memwrite);
                two = "control signals is : regdst" + regdst
                        + "\nj " + j + " jal " + jr + " bne" + bne + " memtoreg " + memtoreg
                        + "\n memread " + memread + " Aluop " + Aluop + " memwrite" + memwrite;

            } else if (flag14 == true && stli == false) {

                rt = getregister(arr[i]);
                lw = false;
                flag14 = false;
                stli = true;

            } else if (flag14 == false && stli == true) {

                rs = getregister(arr[i]);
                lw = false;
                flag14 = true;
                stli = true;

            } else if (flag14 == true && stli == true) {

                immed = getaddress(arr[i]);
                System.out.println("immediate: " + immed);
                two = "immediate: " + immed;
                lw = false;
                flag14 = false;
                stli = false;

            } else if (arr[i].equals("sltui")) {
                currentinst = "sltui";
                System.out.println("sltui");
                one = "stlui";
                lw = false;
                flag15 = true;
                stlui = false;
                op = 010001;
                regdst = false;
                regwrite = true;
                j = false;
                brunch = false;
                jal = false;
                jr = false;
                bne = false;
                memtoreg = false;
                memread = false;
                Aluscr = true;
                Aluop = true;
                memwrite = false;
                System.out.println("control signals is : regdst" + regdst + " j " + j
                        + "\njal " + jr + " bne" + bne + "memtoreg " + memtoreg
                        + "\nmemread " + memread + " Aluop " + Aluop + " memwrite " + memwrite);
                two = "control signals is : regdst" + regdst + " j " + j
                        + "\njal " + jr + " bne" + bne + "memtoreg " + memtoreg
                        + "\nmemread " + memread + " Aluop " + Aluop + " memwrite " + memwrite;

//regdst=true;
            } else if (flag15 == true && stlui == false) {

                rt = getregister(arr[i]);
                System.out.println("register rt: " + rt + " equals" + "0");
                two = "register rt: " + rt + " equals" + "0";
                lw = false;
                flag15 = false;
                stlui = true;
            } else if (flag15 == false && stlui == true) {

                rs = getregister(arr[i]);
                System.out.println("register rt: " + rs + " equals" + "0");
                three = "register rt: " + rs + " equals" + "0";
                lw = false;
                flag15 = true;
                stlui = true;

            } else if (flag15 == true && stlui == true) {

                immed = getaddress(arr[i]);
                System.out.println("immediate : " + immed);
                four = "immediate : " + immed;
                lw = false;
                flag15 = false;
                stlui = false;

            } else if (arr[i].equals("beq")) {
                currentinst = "beq";
                System.out.println("beq");
                one = "beq";
                eleven = "Control Signals are :RegDst :X , RegWrite : 0 , ALUSrc : 0 , AluOp :110 , MemWrite : 0 , MemRead : 0 MemToReg :X";
                lw = false;
                flag16 = true;
                beq = false;
                op = 000100;
                brunch = true;

                regdst = false;
                regwrite = false;
                j = false;
                jal = false;
                jr = false;
                bne = false;
                memtoreg = false;
                memread = false;
                Aluscr = false;
                Aluop = false;
                memwrite = false;
                System.out.println("control signals is : regdst" + regdst + " j " + j
                        + "\n jal " + jr + " bne" + bne + "memtoreg " + memtoreg
                        + "\n memread " + memread + " Aluop " + Aluop + " memwrite " + memwrite);
                two = "control signals is : regdst" + regdst + " j " + j
                        + "\n jal " + jr + " bne" + bne + "memtoreg " + memtoreg
                        + "\n memread " + memread + " Aluop " + Aluop + " memwrite " + memwrite;

            } else if (flag16 == true && beq == false) {

                rt = getregister(arr[i]);
                System.out.println("register rt: " + rt + " equals" + "0");
                two = "register rt: " + rt + " equals" + "0";
                lw = false;
                flag16 = false;
                beq = true;

            } else if (flag16 == false && beq == true) {

                rs = getregister(arr[i]);
                System.out.println("register rt: " + rs + " equals" + "0");
                two = "register rt: " + rs + " equals" + "0";
                lw = false;
                flag16 = true;
                beq = true;

            } else if (flag16 == true && beq == true) {
                address = getaddress(arr[i]);
// System.out.println("address: " + address);
// three="address: " + address;
                lw = false;
                flag16 = false;
                beq = false;
            } else if (arr[i].equals("bne")) {
                currentinst = "bne";
                System.out.println("bne");
                one = "bne";
                eleven = "Control Signals are :RegDst :X , RegWrite : 0 , ALUSrc : 0 , AluOp :110 , MemWrite : 0 , MemRead : 0 MemToReg :X";
                lw = false;
                flag17 = true;
                op = 000101;
                bne = true;
                flagbne = false;
                regdst = false;
                regwrite = false;
                j = false;
                brunch = false;
                jal = false;
                jr = false;
                memtoreg = false;
                memread = false;
                Aluscr = false;
                Aluop = false;
                memwrite = false;
                System.out.println("Control signals are : regdst" + regdst + " j " + j
                        + " jal " + jr + " bne" + bne + "memtoreg " + memtoreg
                        + "memread " + memread + " Aluop " + Aluop + " memwrite " + memwrite);
                two = "Control signals are : regdst" + regdst + " j " + j
                        + " jal " + jr + " bne" + bne + "memtoreg " + memtoreg
                        + "memread " + memread + " Aluop " + Aluop + " memwrite " + memwrite;

            } else if (flag17 == true && flagbne == false) {

                rt = getregister(arr[i]);
                System.out.println("register rt: " + rt + " equals" + " 0");
                two = "register rt: " + rt + " equals" + " 0";
                lw = false;
                flag17 = false;
                flagbne = true;

            } else if (flag17 == false && flagbne == true) {

                rs = getregister(arr[i]);
                System.out.println("register rt: " + rs + " equals" + "0");
                two = "register rt: " + rs + " equals" + "0";
                lw = false;
                flag17 = true;
                flagbne = true;

            } else if (flag17 == true && flagbne == true) {
                address = getaddress(arr[i]);
                System.out.println("address: " + address);
                three = "address: " + address;
                lw = false;
                flag17 = false;
                flagbne = false;
            } else if (arr[i].equals("jal")) {
                currentinst = "jal";
                System.out.println("jal");
                one = "jal";
                lw = false;
                flag18 = true;
                jal = true;
                op = 000011;

                regdst = false;
                regwrite = false;
                j = false;
                brunch = false;
                jr = false;
                bne = false;
                memtoreg = false;
                memread = false;
                Aluscr = false;
                Aluop = false;
                memwrite = false;
                System.out.println("control signals is : regdst" + regdst + " j " + j + " jal "
                        + jr + "\nbne" + bne + "memtoreg " + memtoreg + "memread "
                        + memread + "\n Aluop " + Aluop + " memwrite " + memwrite);
                two = "control signals is : regdst" + regdst + " j " + j + " jal "
                        + jr + "\nbne" + bne + "memtoreg " + memtoreg + "memread "
                        + memread + "\n Aluop " + Aluop + " memwrite " + memwrite;
            } else if (flag18 == true) {

                address = getaddress(arr[i]);
// System.out.println("address: " + address);
// three="address: " + address;
                lw = false;
                flag18 = false;
                ra = writeback(arr[i]);
                System.out.println("addreaa saved in $sra with value :" + ra);
                four = "addreaa saved in $sra with value :" + ra;

            } else if (arr[i].equals("jr")) {
                currentinst = "jr";
                System.out.println("jr");
                one = "jr";
                lw = false;
                flag19 = true;
                op = 000000;
                func = 001000;
                jr = true;
                regdst = false;
                regwrite = true;
                j = false;
                brunch = false;
                jal = false;
                bne = false;
                memtoreg = false;
                memread = false;
                Aluscr = false;
                Aluop = false;
                memwrite = false;
                System.out.println("control signals is : regdst" + regdst
                        + "\n j " + j + " jal " + jr + " bne" + bne + "memtoreg "
                        + memtoreg + "memread " + memread + "\n Aluop " + Aluop + "memwrite " + memwrite);
                two = "Control signals are : regdst" + regdst
                        + "\n j " + j + " jal " + jr + " bne" + bne + "memtoreg "
                        + memtoreg + "memread " + memread + "\n Aluop " + Aluop + "memwrite " + memwrite;
            } else if (flag19 == true) {

                rd = getregister(arr[i]);
                System.out.println("jump to register: " + rd);
                two = "jump to register: " + rd;
                lw = false;
                flag19 = false;

            } else if (arr[i].equals("sw")) {
                currentinst = "sw";
                System.out.println("sw");
                one = "sw";
                lw = false;
                flag20 = true;
                sw = false;
                op = 101011;
                regdst = false;
                regwrite = false;
                j = false;
                brunch = false;
                jal = false;
                jr = false;
                bne = false;
                memtoreg = false;
                memread = false;
                Aluscr = true;
                Aluop = true;
                memwrite = true;
                System.out.println("control signals is : regdst" + regdst + " j "
                        + j + "\njal " + jr + " bne" + bne + "memtoreg " + memtoreg
                        + "memread " + memread + " Aluop " + Aluop + "memwrite " + memwrite);
                two = "Control signals are : regdst" + regdst + " j "
                        + j + " jal " + jr + " bne" + bne + "\nmemtoreg " + memtoreg
                        + "memread " + memread + "\n Aluop " + Aluop + "memwrite " + memwrite;

//regdst=true;
            } else if (flag20 == true && sw == false) {

                rt = getregister(arr[i]);
                System.out.println("register rt: " + rs);
                two = "register rt: " + rs;
                lw = false;
                flag20 = false;
                sw = true;

            } else if (flag20 == false && sw == true) {

                int k = getoffsetindex(arr[i]);
                String c = arr[i].substring(0, k);
                String d = arr[i].substring(k + 1, 5);

                offset = getaddress(c);
                System.out.println("offset is " + offset);
                three = "offset is " + offset;

                rs = getregister(d);
                flag20 = false;
                sw = false;

            }
        }
    }

    public void up() {
        upup = new JPanel(new BorderLayout());
        downup = new JPanel(new BorderLayout());
        numbques = new JLabel(" How many Instruction will you enter ?");
        numbques.setFont(flabels);
        cfrmnumbtn = new JButton("Confirm Number Of Instructions");
        cfrmnumbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noOfInstructions = Integer.parseInt(numb.getText());
                System.out.println("noOfInstructions");
            }
        });
        cfrmnumbtn.setFont(fbtn);
        numb = new JTextArea();
        up = new JPanel();
        output = new JLabel("what's the address you will start with ?");
        output.setFont(flabels);
        numb.setFont(ftxts);
        num = new JTextArea();
        num.setFont(ftxts);
        up.setLayout(new BorderLayout());
        confirmnum = new JButton("Confirm Address");
        confirmnum.setFont(fbtn);
        confirmnum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                beginingaddress = Integer.parseInt(num.getText());
                System.out.println("working");
            }
        });
        downup.add(numbques, BorderLayout.NORTH);
        downup.add(numb, BorderLayout.CENTER);
        downup.add(cfrmnumbtn, BorderLayout.SOUTH);
        upup.add(num, BorderLayout.CENTER);
        upup.add(confirmnum, BorderLayout.SOUTH);
        upup.add(output, BorderLayout.NORTH);
        up.add(upup, BorderLayout.NORTH);
        up.add(downup, BorderLayout.SOUTH);
    }

    public void cases() {
        textareatext = instructions.getText();
        inst = instructions.getText();
        //cfrminstruct = instructions.getText();
        splitarea = textareatext.split("\n");
        cfrminstruct = splitarea[determine];
        if (determine < noOfInstructions) {
            determine++;
        } else {
            determine = 0;
        }
        ten = "The number of cycles is " + determine;
        System.out.println(cfrminstruct);
        instfetc();
        if (("j".equals(currentinst))) {
            eleven = "";
            saveaddress(beginingaddress, cfrminstruct);
            r = beginingaddress;
            whatwillHappen();
            beginingaddress = immed;
            // pcp4();
            setDP();
            timer = new javax.swing.Timer(3000, new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    while (true) {
                        if (immed >= r) {
                            beginingaddress = r + 4;
                            break;
                        }
                        System.out.println("I am temppp" + r);
                        System.out.println("I am immed " + immed + "and I am beqnum" + beqnum);
                        int ip = immed;
                        jump();
                        immed = ip + 4;
                        if (immed > beqnum) {
                            break;
                        }

                    }
                }
            });
            timer.start();
            timer.setRepeats(true);
        } else if (branchresult && ("beq".equals(currentinst)) || ("bne".equals(currentinst))) {
            eleven = "\n"
                    + "Control Signals are :RegDst :X ,"
                    + "\n RegWrite : 0 , ALUSrc : 0 "
                    + ",\n AluOp :110 , MemWrite : 0 ,"
                    + " \nMemRead : 0 MemToReg :X";

            // bradr=beginingaddress;
            saveaddress((beginingaddress), cfrminstruct);
            whatwillHappen();
            beqnum = beginingaddress;
//beginingaddress = ((address*4)+beginingaddress);
            setDP();
            pcp4();
            timer = new javax.swing.Timer(3000, new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    branch();
                    for (int i = 0; i < Math.abs(address) - 1; i++) {
                        pcp4();
                    }
                }
            });
            timer.start();
            timer.setRepeats(false);

        } else if (("jal".equals(currentinst))) {
            eleven = "";
            saveaddress(beginingaddress, cfrminstruct);
            whatwillHappen();
            beginingaddress = immed;
//pcp4();
            pcjal();
            setDP();
            timer = new javax.swing.Timer(3000, new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    jal();
                }
            });
            timer.start();
            timer.setRepeats(false);
        } else if (("jr".equals(currentinst))) {
            eleven = "";
            saveaddress(beginingaddress, cfrminstruct);
            whatwillHappen();
            beginingaddress = ra;
            pcp4();
//pcjal();
            setDP();
            timer = new javax.swing.Timer(3000, new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    jr();
                }
            });
            timer.start();
            timer.setRepeats(false);
        } else if (!"jal".equals(currentinst) || !"jr".equals(currentinst) || !"j".equals(currentinst) || currentinst != "beq" || currentinst != "bne") {
            eleven = "";
            saveaddress(beginingaddress, cfrminstruct);
            whatwillHappen();
            pcp4();
            setDP();
        }
    }

    public void pcjal() {
        rareg = beginingaddress + 4;
    }

    public String search4() {
        int index = addressarray.indexOf(rareg);
        System.out.println(rareg);
        return stringarray.get(index);
    }

    public void jr() {
        cfrminstruct = search4();
        System.out.println("I am the current instruction " + cfrminstruct);
        instfetc();
        if (("j".equals(currentinst))) {
            saveaddress(immed, cfrminstruct);
            whatwillHappen();
            beginingaddress = immed;
            pcp4();
            setDP();
        } else {
            saveaddress(beginingaddress, cfrminstruct);
            whatwillHappen();
            pcp4();
            setDP();
        }
        System.out.println("I am the jump tongue emoticon");
    }

    public void center() {

        center = new JPanel();
        cup = new JPanel();
        cup.setLayout(new BorderLayout());
        instruct = new JLabel("Enter the Instructions here");
        instruct.setFont(flabels);
        instructions = new JTextArea();
        instructions.setFont(ftxts);
        confirminst = new JButton("Confirm Instructions");
        JScrollPane scroll = new JScrollPane(instructions, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        instructions.setLineWrap(true);
        instructions.setWrapStyleWord(true);
        cup.add(scroll, BorderLayout.CENTER);
        scroll.setPreferredSize(new Dimension(1000, 70));
        confirminst.setFont(fbtn);
        confirminst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cases();
            }
        });
        cup.add(instruct, BorderLayout.NORTH);
        //cup.add(instructions, BorderLayout.CENTER);
        cup.add(confirminst, BorderLayout.SOUTH);
        DataPathIMG = new JLabel();
        center.setLayout(new BorderLayout());
        center.add(cup, BorderLayout.NORTH);
        coc = new JPanel();
        coc.setLayout(new BorderLayout());
        x = new JTextArea();
        x.setBackground(getBackground());
        x.setFont(flabels);
        setDP();
        JScrollPane scroll2 = new JScrollPane(x, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        x.setLineWrap(true);
        x.setWrapStyleWord(true);
        // cup.add(scroll,BorderLayout.CENTER);
        scroll2.setPreferredSize(new Dimension(550, 10));
        leftcenter = new JPanel(new BorderLayout());
        leftcenter.add(DataPathIMG, BorderLayout.EAST);
        leftcenter.add(scroll2, BorderLayout.WEST);
        center.add(leftcenter, BorderLayout.CENTER);
    }

    public String toBinary(int a) {
        return Integer.toBinaryString(a);
    }

    public String jumpaddress() {
        String a = Integer.toBinaryString(beginingaddress);
        String result = a.substring(0, 4);
        String bin = Integer.toBinaryString(immed * 4);
        String postiveconc = "0000000000000000";
        String negativeconc = "1111111111111111";
        immed2 = immed + "";
        if (immed2.charAt(0) == '0') {
            immed2 = result + postiveconc + bin;
            return immed2;
        } else /*if (immed2.charAt(0) == '1') */ {
            immed2 = result + negativeconc + bin;
            return immed2;
        }
    }

    public void whatwillHappen() {
        ALUcontrol();
        regfile(res);
        if (currentinst == "j") {
            String plus = "The target instruction decoding would be \n" + jumpaddress();
            five = "address is " + beginingaddress + " equivalent value in Hexadecimal is " + Integer.toHexString(beginingaddress) + "\n" + plus;
        } else {
            five = "address is " + beginingaddress + " equivalent value in Hexadecimal is " + Integer.toHexString(beginingaddress) + "\n";
        }
        result = one + "\n" + two + "\n" + three + "\n" + four + five + six + seven + eight + nine + ten + eleven + "\n" + fffff + "\n" + str + "  " + lwswresult;
        x.setText(result);
    }

    public void signextend() {
        String postiveconc = "0000000000000000";
        String negativeconc = "1111111111111111";
        immed2 = immed + "";
        if (immed2.charAt(0) == '0') {
            immed2 = postiveconc + immed2;
        } else if (immed2.charAt(0) == '1') {
            immed2 = negativeconc + immed2;
        }
    }

    public String search() {
        indexx = addressarray.indexOf(immed);
        System.out.println("I sm immed" + immed);
        return stringarray.get(indexx);
    }

    public String search3() {
        int index = addressarray.indexOf(address);
        System.out.println(address);
        return stringarray.get(index);
    }

    public void jump() {
        cfrminstruct = search();
        System.out.println("I am the current instruction " + cfrminstruct);
        instfetc();
        beginingaddress = addressarray.get(indexx);
        if (("j".equals(currentinst))) {
            eleven = "";
            saveaddress(beginingaddress, cfrminstruct);
            whatwillHappen();
            pcp4();
            setDP();
            timer = new javax.swing.Timer(3000, new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    jump();
                }
            });
            timer.start();
            timer.setRepeats(false);
        } else if (branchresult && ("beq".equals(currentinst)) || ("bne".equals(currentinst))) {
            eleven = "\n"
                    + "Control Signals are :RegDst :X ,"
                    + "\n RegWrite : 0 , ALUSrc : 0 "
                    + ",\n AluOp :110 , MemWrite : 0 ,"
                    + " \nMemRead : 0 MemToReg :X";

//            bradr=beginingaddress;
            saveaddress((beginingaddress), cfrminstruct);
            whatwillHappen();
//beginingaddress = ((address*4)+beginingaddress);
            setDP();
            pcp4();
            timer2 = new javax.swing.Timer(3000, new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    passedbybeq = true;
                    branch();
                    for (int i = 0; i < Math.abs(address) - 1; i++) {
                        pcp4();
                    }
                }
            });
            timer2.start();
            timer2.setRepeats(false);

        } else if (("jal".equals(currentinst))) {
            eleven = "";
            saveaddress(beginingaddress, cfrminstruct);
            whatwillHappen();
//pcp4();
            pcjal();
            setDP();
            timer = new javax.swing.Timer(3000, new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    jal();
                }
            });
            timer.start();
            timer.setRepeats(false);
        } else if (("jr".equals(currentinst))) {
            eleven = "";
            saveaddress(beginingaddress, cfrminstruct);
            whatwillHappen();
            beginingaddress = ra;
            pcp4();
//pcjal();
            setDP();
            timer = new javax.swing.Timer(3000, new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    jr();
                }
            });
            timer.start();
            timer.setRepeats(false);
        } else if (!"jal".equals(currentinst) || !"jr".equals(currentinst) || !"j".equals(currentinst) || currentinst != "beq" || currentinst != "bne") {
            eleven = "";
            five = "";
            saveaddress(beginingaddress, cfrminstruct);
            whatwillHappen();
            setDP();
        }
        System.out.println("I am the jump tongue emoticon");
    }

    public void jal() {
        cfrminstruct = search3();
        System.out.println("I am the current instruction " + cfrminstruct);
        instfetc();
        if (("j".equals(currentinst))) {
            saveaddress(immed, cfrminstruct);
            whatwillHappen();
            beginingaddress = immed;
            pcp4();
            setDP();
        } else {
            saveaddress(beginingaddress, cfrminstruct);
            whatwillHappen();
            pcp4();
            setDP();
        }
        System.out.println("I am the jump tongue emoticon");
    }
    int jj;

    public String search2() {
        int index;
        int n = (address) * 4;
        System.out.println("Iam n" + n);
        int y = beqnum + 4;
        System.out.println("I am thee begining address " + y);
        jj = n + y;
        beqnum = jj;
        System.out.println("I am the desired address" + jj);
        index = addressarray.indexOf(jj);
        System.out.println("I am the new index" + index);
        return stringarray.get(index);
    }

    public void branch() {
        cfrminstruct = search2();
        beginingaddress = beqnum;
        System.out.println("I am the current instruction " + cfrminstruct);
        instfetc();
        if (("j".equals(currentinst))) {
            eleven = "";
            saveaddress(beginingaddress, cfrminstruct);
            whatwillHappen();
            beginingaddress = immed;
            if (!(immed == -1)) {
                pcp4();
            }
            setDP();
            timer = new javax.swing.Timer(3000, new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    jump();
                }
            });
            timer.start();
            timer.setRepeats(false);
        } else if (branchresult && ("beq".equals(currentinst)) || ("bne".equals(currentinst))) {
            eleven = "\n"
                    + "Control Signals are :RegDst :X ,"
                    + "\n RegWrite : 0 , ALUSrc : 0 "
                    + ",\n AluOp :110 , MemWrite : 0 ,"
                    + " \nMemRead : 0 MemToReg :X";

//            bradr=beginingaddress;
            saveaddress((beginingaddress), cfrminstruct);
            whatwillHappen();
//beginingaddress = ((address*4)+beginingaddress);
            setDP();

            timer2 = new javax.swing.Timer(3000, new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    passedbybeq = true;
                    branch();
                    for (int i = 0; i < Math.abs(address) - 1; i++) {
                        pcp4();
                    }
                }
            });
            timer2.start();
            timer2.setRepeats(false);

        } else if (("jal".equals(currentinst))) {
            eleven = "";
            five = "";
            saveaddress(beginingaddress, cfrminstruct);
            whatwillHappen();
            beginingaddress = immed;
//pcp4();
            pcjal();
            setDP();
            timer = new javax.swing.Timer(3000, new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    jal();
                }
            });
            timer.start();
            timer.setRepeats(false);
        } else if (("jr".equals(currentinst))) {
            eleven = "";
            five = "";
            saveaddress(beginingaddress, cfrminstruct);
            whatwillHappen();
            beginingaddress = ra;
            //   pcp4();
//pcjal();
            setDP();
            timer = new javax.swing.Timer(3000, new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    jr();
                }
            });
            timer.start();
            timer.setRepeats(false);
        } else {
            five = "";
            eleven = "";
            saveaddress(beginingaddress, cfrminstruct);
            whatwillHappen();
            setDP();
        }
        if (!(immed == -1)) {
            pcp4();
        }
        System.out.println("I am the branch:D");
    }

    void pcp4() {
        beginingaddress += 4;
    }

    public void saveaddress(int f, String s) {
        addressarray.add(f);
        stringarray.add(s);
    }

    public int indexaddress(int y) {
        for (int i = 0; i < addressarray.size(); i++) {
            if (addressarray.get(i) == y) {
                return i;
            }
        }
        return 0;
    } //return index of address that save instruction in it we will use it in case of jump to jump to aspecified instruction determined by its address

    public void shiftleft() {
        char[] temp = new char[immed2.length()];
        int i = 0;
        for (; i < (immed2.length() - 2); i++) {
            temp[i] = immed2.charAt(i);
        }
        temp[i++] = 1;
        temp[i] = 1;
        immed2 = temp.toString();
    }

    public void branch_address() {
        signextend();
        shiftleft();
        pcp4();
        int temp1 = Integer.parseInt(pcp4, 2);
        int temp2 = Integer.parseInt(immed2, 2);
        int temp3 = temp1 + temp2;
        BranchAddress = Integer.toBinaryString(temp3);
        seven = "address is : " + BranchAddress;
    }

    public void jump_address() {
        immed2 = immed + "";
        char[] temp = new char[4];
        pcp4();
        for (int i = 0; i < 4; i++) {
            temp[i] = immed2.charAt(i);
        }
        String t = temp.toString();
        shiftleft();
        JumpAddress = t + immed2;
        six = "adress is " + JumpAddress;
    }

    public void setDP() {

        switch (currentinst) {
            case "addi":
            case "andi":
            case "ori":
            case "slti":
            case "sltui": {
                DataPathIMG.setIcon(new ImageIcon("D:\\addi.png"));
                break;
            }
        }
        switch (currentinst) {
            case "addi": {
                DataPathIMG.setIcon(new ImageIcon("D:\\addi.png"));
                break;
            }
            case "lw": {
                DataPathIMG.setIcon(new ImageIcon("D:\\lw.png"));
                break;
            }
            case "sw": {
                DataPathIMG.setIcon(new ImageIcon("D:\\sw.png"));
                break;
            }
            case "or": {
                DataPathIMG.setIcon(new ImageIcon("D:\\or.png"));
                break;
            }
            case "beq": {
                DataPathIMG.setIcon(new ImageIcon("D:\\beq.png"));
                break;
            }
            case "j": {
                DataPathIMG.setIcon(new ImageIcon("D:\\j.png"));
                break;
            }
            case "bne": {
                DataPathIMG.setIcon(new ImageIcon("D:\\bne.png"));
                break;
            }
            case "jr": {
                DataPathIMG.setIcon(new ImageIcon("D:\\jr.png"));
                break;
            }
            default:
                DataPathIMG.setIcon(new ImageIcon("D:\\fd.jpg"));
        }
    }
}

public class JavaApplication27 {

    public static void main(String[] args) {
        MipsFrame m = new MipsFrame();
        m.setVisible(true);

    }
}
