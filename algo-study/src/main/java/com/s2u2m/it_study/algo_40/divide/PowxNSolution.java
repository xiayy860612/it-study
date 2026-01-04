package com.s2u2m.it_study.algo_40.divide;

// https://leetcode.cn/problems/powx-n/
public class PowxNSolution {
    public double myPow(double x, int n) {
        return n > 0 ? pow(x, n) : 1 / pow(x, -n);
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        double half = pow(x, n / 2);
        double result = half * half;
        if (n % 2 == 1) {
            result *= x;
        }
        return result;
    }
}
