#include <iostream>
#include <vector>
#include <string>
#include <string.h>
#include <algorithm>

int main(int argc, char* argv[])
{
    
    std::vector<std::string> odds;
    std::vector<std::string>* evens = new std::vector<std::string>;

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
    
    return 0;
}