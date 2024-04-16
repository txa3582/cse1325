#include "inch.h"
#include <fstream>
#include <string>
#include <sstream>

Inch in, last_in, sum;


int main(int argc, char* argv[])
{
    // read file
    std::ifstream ist{std::string{argv[1]}};
    if(!ist) throw std::runtime_error{"can't open input file"};



    // write file
    std::ofstream ofs {std::string{argv[2]}};
    if(!ofs) throw std::runtime_error{"can't open output file"};

    
    std::cout << "Starting sum is " << sum <<", last entry was " << last_in << std::endl;
    std::cout << "Writing inputs to " << argv[2] << std::endl;
    std::string s;

    while (std::getline(ist, s))
    {   
        ofs << s << std::endl;
        std::cout << "\n" << std::endl;
        std::cout << "Read " << s << " from " << argv[1] << std::endl;
        std::istringstream iss(s);
        iss >> in;
        std::cout << "\n" << std::endl;
        sum = sum + in;
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
  
    while (std::cin)
    {

        std::cout << "Enter one or more measurements (in inches): ";
        std::cin >> in;
        std::cout << "\n" << std::endl;
        std::cout << "You entered  " << in;
        ofs << in << std::endl;
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
    
    ist.close();
    ofs.close();
    

    
    return 0;
}