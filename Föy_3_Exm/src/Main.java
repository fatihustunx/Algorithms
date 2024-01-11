using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace GaussJordanYontemi
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Matris boyutunu giriniz: ");
            int boyut = Convert.ToInt32(Console.ReadLine());

            double[,] matris = new double[boyut, boyut];
            double[] deger = new double[boyut];



            for (int i = 0; i < boyut; i++)
            {
                for (int j = 0; j < boyut; j++)
                {
                    Console.Write((i + 1) + "satir" + (j + 1) + ".sutundaki elemani giriniz: ");
                    matris[i, j] = Convert.ToDouble(Console.ReadLine());
                }
            }


            for (int i = 0; i < boyut; i++)
            {
                Console.Write((i + 1) + ". degeri giriniz : ");
                deger[i] = Convert.ToDouble(Console.ReadLine());

            }

            GaussJordan(matris, deger, boyut);
            Console.ReadLine();
        }

        static void GaussJordan(double[,] matris, double[] deger, int boyut)
        {
            for (int i = 0; i < boyut; i++)
            {
                double geciciIlk = matris[i, i];
                for (int k = 0; k < boyut; k++)
                {
                    matris[i, k] /= geciciIlk;
                }
                deger[i] /= geciciIlk;


                for (int j = i + 1; j < boyut; j++)
                {
                    double carpim = matris[j, i] / matris[i, i];

                    for (int l = 0; l < boyut; l++)
                    {
                        matris[j, l] = matris[j, l] - (carpim * matris[i, l]);
                    }
                    deger[j] = deger[j] - (carpim * deger[i]);
                }
            }

            for (int i = boyut - 1; i > 0; i--)
            {

                for (int j = i - 1; j >= 0; j--)
                {
                    double carpim = matris[j, i] / matris[i, i];
                    for (int k = 0; k < 3; k++)
                        matris[j, k] -= matris[i, k] * carpim;
                    deger[j] -= deger[i] * carpim;
                }
            }




            Console.WriteLine();
            for (int i = 0; i < boyut; i++)
                Console.WriteLine("x(" + i + ") : " + deger[i]);


        }

    }
}














