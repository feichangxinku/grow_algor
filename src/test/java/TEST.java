/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */

/**
 *
 * @author zichun
 * @version $Id: TEST.java, v 0.1 2018年04月17日 下午6:48 zichun Exp $
 */
public class TEST {
        public static void main(String[] args) {
            int dim_size=3;
            int q_size =5;
            double[] SOQ_list = {0.7,0.4,0.2,1,1};
            double[] Trans_SOD_mat = new double[dim_size];
            double[][] WOQ_mat = {{0.2,0.1,0.1,0.1,0.2},{0,0.5,0,0,0},{0.1,0,0.2,0.2,0.2}};

            double[] WOD_mat = {0.2,0.1,0.2};//维度在总分中的权重数组
            double[] SOD_mat = new double[dim_size];//维度得分数组
            // double[][] c = new double[dim_size][q_size];
            double GS = 0;

            // SOQ_list = {0.7,0.4,0.2,1,1};


            //计算维度能力得分
            for(int i=0;i<dim_size;i++) {
                double temp = 0.0;
                for (int j=0;j<q_size;j++) {
                    temp +=WOQ_mat[i][j]*SOQ_list[j];
                    SOD_mat[i] = temp;
                }
            }

            //维度得分的映射
            for(int n=0;n<dim_size;n++){
                Trans_SOD_mat[n] = SOD_mat[n]*10;
            }
            //print dim_weight array
            for(int x=0;x<dim_size;x++){
                System.out.println(SOD_mat[x]);
                System.out.println(Math.round(Trans_SOD_mat[x]));
            }

            //计算最终评分
            double temp1 = 0;
            for (int k=0;k<dim_size;k++){
                temp1 += SOD_mat[k]*WOD_mat[k];
            }
            //总分的映射
            GS = temp1/0.5*600;

            System.out.println(GS);
            System.out.println(temp1);

            //1*10 Array
            // double[] QSList = { 0.1, 0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,1.0};
            //6*10 matrix
            // double[][] QWDMat = {QSList,QSList,QSList,QSList,QSList,QSList};
            //1*6 Array
            // double[] DWList = {0.2,0.2,0.1,0.1,0.2,0.2};
            //1*6
            //double [] DSList ;

        }
}
