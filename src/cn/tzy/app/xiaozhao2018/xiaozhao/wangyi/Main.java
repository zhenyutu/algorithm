    package cn.tzy.app.xiaozhao2018.xiaozhao.wangyi;

    import java.util.Arrays;
    import java.util.Scanner;

    /**
     * Created by tuzhenyu on 18-3-27.
     * @author tuzhenyu
     */
    public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int[] lbx = new int[n];
            int[] lby = new int[n];
            int[] rtx = new int[n];
            int[] rty = new int[n];
            for (int i=0;i<n;i++){
                lbx[i] = scanner.nextInt();
            }
            for (int i=0;i<n;i++){
                lby[i] = scanner.nextInt();
            }
            for (int i=0;i<n;i++){
                rtx[i] = scanner.nextInt();
            }
            for (int i=0;i<n;i++){
                rty[i] = scanner.nextInt();
            }

            int lx_min = getMin(lbx);
            int ly_min = getMin(lby);
            int rx_max = getMax(rtx);
            int ry_max = getMax(rty);

            int max = Integer.MIN_VALUE;
            for (int i=lx_min;i<=rx_max;i++){
                for (int j=ly_min;j<=ry_max;j++){
                    int count = 0;
                    for (int k=0;k<n;k++){
                        if (i>lbx[k]&&i<rtx[k]&&j>lby[k]&&j<rty[k])
                            count++;
                    }
                    max = Math.max(max,count);
                }
            }
            System.out.println(max);

        }

        private static int getMin(int[] arr){
            int min = Integer.MAX_VALUE;
            for (int i=0;i<arr.length;i++){
                if (arr[i]<min)
                    min = arr[i];
            }
            return min;
        }

        private static int getMax(int[] arr){
            int max = Integer.MIN_VALUE;
            for (int i=0;i<arr.length;i++){
                if (arr[i]>max)
                    max = arr[i];
            }
            return max;
        }
    }
