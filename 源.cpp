#include<iostream>
#include<cstring>
using namespace std;
int cntstring(char*source,char*substr);
void main()
{
	char str1[50],str2[20];
	cout<<"input source string:";
	cin.getline(str2,20);
	cout<<"Occurs:"<<cntstring(str1,str2)<<endl;
}
int cntstring(char*source,char*substr)
{
	int sum=0;
	char*p1=source,*p2=substr;
	while(*p1!='\0')
	{
		if(*p1==*p2)
			while(*p1==*p2&&*p2!='\0')
			{
				p1++;
				p2++;
			}
		else
			p1++;
		if(*p2=='\0')
			sum++;
		p2=substr;
	}
	return sum;
}