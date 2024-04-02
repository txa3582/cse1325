#include <iostream>
#include <vector>
#include <string>
#include <string.h>
#include <algorithm>
#include <random> 
#include <chrono>  

int main(int argc, char* argv[])
{
    
    std::vector<std::string> odds;
    std::vector<std::string>* evens = new std::vector<std::string>;
    unsigned seed = std::chrono::system_clock::now().time_since_epoch().count();
    int len = 0;
    std::string word;  
    for (int i = 1; i < argc; i++)
    {
        word = argv[i];
        len = word.length();

        if (len % 2 == 0)
        {
            (*evens).push_back(word);
        }
        else
        {
            odds.push_back(word);
        }
        
    }
    std::sort(odds.begin(), odds.end());


    std::cout << "Odd lengths(Sorted): \n"<< std::endl;


    std::shuffle(evens->begin(), evens->end(), std::default_random_engine(seed));
    for (int i = 0; i < odds.size() ; i++)
    {
        std::cout << odds[i] << std::endl;
    }
    std::cout << "\n"<< std::endl;
    std::cout << "Even lengths(Sorted): \n"<< std::endl;
    for (int i = 0; i < evens->size(); i++)
    {
        std::cout << (*evens)[i] << std::endl;
    }
    
    return 0;
}