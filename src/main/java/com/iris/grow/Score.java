/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.iris.grow;

/**
 *
 * @author zichun
 * @version $Id: Score2.java, v 0.1 2018年04月17日 下午9:44 zichun Exp $
 */

/**
 * declare:
 * SOQ_list:ListOfScoreOfQuestion (10*1)
 * WOQ_mat:MatrixOfWeightOfQuestionInEachDimension (6*10)
 * SOD_mat:MatrixOfScoreOfDimension(6*1)
 * Trans_SOD_mat:TransposeOfSOD_mat(1*6)
 * WOD_mat:MatrixOfWeightOfDimensionInGlobalScore(6*1)
 * GS:AggregateScore(value)
 */

public class Score {
    //Input size
    private int dim_size;
    private int q_size;

    //Input parameters
    private double[][] WOQ_mat;
    private double[] SOQ_list;
    private double[] WOD_mat;


    public int[] DimScores(double[][]WOQ_mat,
                           double[]SOQ_list,
                           int dim_size,
                           int q_size) {
        //double[] SOD_mat = new double[dim_size];
        int[] Trans_SOD_mat = new int[dim_size];

        for(int i=0;i<dim_size;i++) {
            double temp = 0.0;
            for (int j=0;j<q_size;j++) {
                temp +=WOQ_mat[i][j]*SOQ_list[j];
                // transfer to integer for radar
                Trans_SOD_mat[i] = (int)Math.round(temp*10);
            }
        }

        //output MatrixOfScoreOfDimension
        return Trans_SOD_mat;
    }

    public int GlobalScore(double[] WOD_mat,
                           int[]Trans_SOD_mat,
                           int dim_size) {

        int GS_int;
        //compute final score
        double temp1 = 0;
        for (int k=0;k<dim_size;k++){
            temp1 += Trans_SOD_mat[k]*WOD_mat[k];
        }
        //mapping to final score for pk
        GS_int = (int)Math.round(temp1/0.5*600/10);

        return GS_int;

    }

}

