#include "inch.h"

Inch in, last_in, sum;


int main(int argc, char* argv[])
{
    std::cin >> in;

    sum = sum + in;

    std::cout << in;

    if(in == last_in) std::cout << in << "==" << last_in << std::endl;
    if(in != last_in) std::cout << in << "!=" << last_in << std::endl;
    if(in <  last_in) std::cout << in << "< " << last_in << std::endl;
    if(in <= last_in) std::cout << in << "<=" << last_in << std::endl;
    if(in >  last_in) std::cout << in << "> " << last_in << std::endl;
    if(in >= last_in) std::cout << in << ">=" << last_in << std::endl;

    std::cout << sum;

    last_in = in;

    
    return 0;
}