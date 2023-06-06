struct data1 
{
    int n;
    int X<>;
    int Y<>;   
};

struct data2
{
    int n;
    int X<>;
    int Y<>;   
};

struct data3
{
    double r;
    int n;
    int X<>;
    int Y<>; 
};
struct out2
{
    double A<2>;
};
struct out3
{
    double B<>;
};


program VECTOR_ASK1 
{
    version INNERPRODUCT_VERSION 
    {
        int INNERPRODUCT(data1) = 1; 
    } = 2;
    version AVGEXEY_VERSION 
    {
        out2 AVGEXEY(data2) = 1; 
    } = 3;
    version GIN_VERSION 
    {
        out3 GIN(data3) = 1;
    } = 4;

} =0x12345678;