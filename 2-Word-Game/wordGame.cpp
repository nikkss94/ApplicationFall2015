#include<iostream>
using namespace std;

string word;
char matrix[100][100];
 int a;
 int b;
 bool check(int x, int y,int ax, int ay)
 {
     for(int i=0;i< word.size();i++)
     {

        if (x+i*ax >= a or x+i*ax < 0 )
         return 0;
        if (y+i*ay >= b or y+i*ay < 0)
            return 0;
         if ( matrix[x+i*ax][y+i*ay] != word[i])
            return 0;
     }
     return 1;
 }

int main()
{
    int counter = 0;
    cin >> a >> b;
    for (int i=0;i<a;i++)
     for (int j=0;j<b;j++)
         cin>>matrix[i][j];
    cin>>word;
    for(int x=0;x<a;x++)
            for(int y=0;y<b;y++)
                for(int ax=-1;ax<=1;ax++)
                    for(int ay=-1;ay<=1;ay++)
                        if(ax*7+ay*3 != 0)
                            counter += check(x,y,ax,ay);

    cout<<counter<<endl;
}
