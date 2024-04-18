#include "university.h"
#include <fstream>
#include <vector>
#include <map>

typedef std::string State; 
typedef std::vector<University> Universities; 

int main(int argc, char* argv[])
{
    if (argc != 2)
    {
        std::cerr << argv[1] << std::endl;
        return -1;
    }
    
    std::ifstream ist{std::string{argv[1]}};
    if(!ist)
    {
        throw std::runtime_error{"can't open input file"};
        return -2;
    } 


    
    return 0;
}