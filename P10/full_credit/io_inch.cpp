#include "inch.h"

Inch in, last_in, sum;


int main()
{

    std::cout << "Starting sum is " << sum <<", last entry was " << last_in;
    while (std::cin)
    {
       
        std::cout << "\n" << std::endl;
        std::cout << "Enter one or more measurements (in inches): ";
        std::cin >> in;
        std::cout << "\n" << std::endl;
        std::cout << "You entered  " << in;
        sum = sum + in;
        std::cout << "\n" << std::endl;

        if(in == last_in) std::cout << "Same legth as last time!" << std::endl;
        if(in != last_in) std::cout << "NOT the same length as last time." << std::endl;
        if(in <  last_in) std::cout << "Smaller than the length last time." << std::endl;
        if(in <= last_in) std::cout << "Smaller or same length as last time." << std::endl;
        if(in >  last_in) std::cout << "Bigger than the length last time." << std::endl;
        if(in >= last_in) std::cout << "Bigger or same length as last time." << std::endl;

        std::cout << "Sum so far is " << sum << std::endl;
        std::cout << "\n" << std::endl;

        last_in = in;
    }
    
    

    
    return 0;
}