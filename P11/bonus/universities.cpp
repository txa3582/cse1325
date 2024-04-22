#include "university.h"
#include <fstream>
#include <vector>
#include <map>
#include <string>
#include <sstream>

typedef std::string State; 
typedef std::vector<University> Universities; 

template<class T, class U>
std::ostream& operator<<(std::ostream& ost, const std::pair<T,U>& p) {
    return ost << "[" << p.first << "," << p.second << "]";
}

template<class T, class U>
void print_container(const T& t)
{
    typedef Universities it = t.begin();
    for(const auto& universities : it->second) std::cout << universities << std::endl;
}
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
    
    State state;
    University university;
    std::map<State, Universities> m;
    while (!ist.eof())
    {
        std::getline(ist, state);
        ist >> university;

        if (m.find(state) == m.end())
        {
            m[state] = Universities();
        }
        m[state].push_back(university);
    }
    while (std::cin)
    {
        std::cout << "\n" << std::endl;   
        std::cout << "Enter a 2 character abbreviation for the state: ";
        if (!std::cin)
        {
            break;
        }
        std::cin >> state;
        print_container(m);
        
        auto it = m.find(state);
        if (it == m.end())
        {
            std::cout << "No universities found in " << state << std::endl;
            break;
        }
        for(const auto& universities : it->second) std::cout << universities << std::endl;
    }
        

    

}