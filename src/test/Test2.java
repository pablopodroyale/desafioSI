package test;

	import java.io.*;

	public class Test2 {

	    public static void main(String args[]) throws IOException, InterruptedException {
	        String cohete[];
	        int estado[];
	        int i;
	        int j;
	        int k;
	        int a;
	        String humo = " * * * * *";

	        System.out.print("Presione una tecla para iniciar el lanzamiento...");
	        System.in.read(); 
	        cohete=new String[9];
	        cohete[0]="   /|\\   ";
	        cohete[1]="   |B|   ";
	        cohete[2]="   |O|   ";
	        cohete[3]="   |M|   ";
	        cohete[4]="   |B|   ";
	        cohete[5]="  //|\\\\  ";
	        cohete[6]=" ******* ";
	        cohete[7]="* * * * *";
	        cohete[8]=" * * * * ";
	        for (i=1;i<=4;i++) {
	            System.out.print('\u000C'); 
	            for (j=1;j<=15;j++) {
	                System.out.println("");
	            }
	            for (j=1;j<=6;j++) {
	                System.out.println(cohete[j-1]);
	            }
	            System.out.println("");
	            a = 4-i;
	            System.out.println("Lanzamiento en "+a);
	            Thread.sleep(1*1000);
	        }

	        for (i=1;i<=10;i++) {
	            System.out.print('\u000C'); 
	            for (j=1;j<=15-i;j++) {
	                System.out.println("");
	            }
	            for (j=1;j<=8;j++) {
	                System.out.println(cohete[j-1]);
	            }
	            if (i>1) {
	                for (k=0; k<i; k++) {
	                    System.out.println(" * * * * ");
	                }
	            }
	            Thread.sleep((1/1)*1000);
	        }

	        estado=new int[6];
	        estado[0]=3;
	        estado[1]=2;
	        estado[2]=1;
	        estado[3]=2;
	        estado[4]=3;
	        estado[5]=4;
	        for (i=1;i<=10;i++) {
	            System.out.print('\u000C');
	            for (j=1;j<=5+i;j++) {
	                System.out.println("");
	            }
	            for (j=1;j<=6;j++) {
	                estado[j-1]=estado[j-1]-1;
	                switch (estado[j-1]) {
	                    case 0:
	                    cohete[j-1]="    +    ";
	                    break;
	                    case -1: case -5:
	                    cohete[j-1]="   +X+   ";
	                    break;
	                    case -2: case -4:
	                    cohete[j-1]="  +XXX+  ";
	                    break;
	                    case -3:
	                    cohete[j-1]=" +XXXXX+ ";
	                    break;
	                    case -6:
	                    cohete[j-1]="         ";
	                    break;
	                }
	                System.out.println(cohete[j-1]);
	            }
	            Thread.sleep(1*800);
	        }

	    } //Cierre main

	}


