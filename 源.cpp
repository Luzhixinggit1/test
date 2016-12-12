#include<iostream>
#include<iomanip>
#include<ctime>           
using namespace std;
#define N 5
struct birthday
{
	int year;
	int month;
	int day;
};
struct
{
	long num;
	char name[20];
	struct birthday bir;
	char sex[5];
	char local[8];
}stu[N];
int cntage(struct birthday*pd1,struct tm*pd2)
{
	int dyear=(*pd2).tm_year+1900-(*pd1).year;
	int dmonth=(*pd2).tm_mon+1-(*pd1).month;
	int dday=(*pd2).tm_mday-(*pd1).day;
	if(dmonth<0||dmonth==0&&dday<0)
		dyear--;
	return dyear;
}
int main()
{
	int i;
	struct tm*ptm;
	time_t timer;
	timer=time(0);
	ptm=localtime(&timer);
	for(i=0;i<N;i++)
	{
		cout<<"请输入第"<<i+1<<"学员的学号："<<endl;
		cin>>stu[i].num;
		cout<<"请输入第"<<i+1<<"学员的姓名："<<endl;
		cin>>stu[i].name;
		cout<<"请输入第"<<i+1<<"学员的出生日期（例如：1991 1 21）："<<endl;
		cin>>stu[i].bir.year>>stu[i].bir.month>>stu[i].bir.day;
		cout<<"请输入第"<<i+1<<"学员的性别："<<endl;
		cin>>stu[i].sex;
		cout<<"请输入第"<<i+1<<"学员的籍贯："<<endl;
		cin>>stu[i].local;
	}
	cout<<setw(10)<<"学号"<<setw(10)<<"姓名"<<setw(10)<<"年龄"<<setw(10)<<"性别"<<setw(10)<<"籍贯"<<endl;
	for(i=0;i<N;i++)
	{
		cout<<setw(10)<<stu[i].num;
		cout<<setw(10)<<stu[i].name;
		cout<<setw(10)<<cntage(&stu[i].bir,ptm)<<"岁";
		cout<<setw(8)<<stu[i].sex;
		cout<<setw(8)<<stu[i].local<<endl;
	}
	return 0;
}