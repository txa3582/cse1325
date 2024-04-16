#include "inch.h"
#include <fstream>
Inch in, last_in, sum;


int main(int argc, char* argv[])
{

    std::cout << "Starting sum is " << sum <<", last entry was " << last_in;
    while (std::cin)
    {
        // read file
        std::ifstream ist{std::string{argv[1]}};
        if(!ist) throw std::runtime_error{"can't open input file"};

        std::string s;
        while(std::getline(ist, s)) std::cout << s << std::endl;

        
        std::ofstream ofs {std::string{argv[1]}};

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