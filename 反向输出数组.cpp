#include<iostream>
using namespace std;
void main()
{
	char string[10]="C program";
	char*ptr;
	ptr=string;
	cout<<ptr<<endl;
	while(*ptr!='\0')
		ptr++;
	while(ptr>string)
	{
		ptr--;
	cout<<*ptr;
	}
}
