#include "linear.h"

int main(int argc, char* argv[])
{
    if(argc != 3 || argc != 4)
    {
        std::cerr << "Invalid polynomial size - must be linear or quadratic" << std::endl;
        exit(-1);
    }
    std::vector<double> linearv = {1.0,2.0};
    Polynomial* p = new Linear(linearv);

    // if(argc == 3)
    // {
        
    // }
    // if(argc == 4)
    // {
        
    // }

    // Fix destructors
    return 0;
}
