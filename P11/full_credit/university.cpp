#include "university.h"
University::University(std::string name, int enrollment)
: _name{name}, _enrollment{enrollment}{}

const std::string University::name()
{
    return _name;
}
const int University::enrollment()
{  
    return _enrollment;
}
std::istream& operator>>(std::istream& ist, University& reading)
{
    std::getline(ist, reading._name);
    ist >> reading._enrollment;
    ist >> std::ws;
    void validate();
    return ist;
}

std::ostream& operator<<(std::ostream& ost, const University& reading)
{
    ost << reading._name << " " << " has enrollement of " << reading._enrollment;
    return ost;
}

void University::validate()
{
    if (_enrollment < 0)
    {
        throw std::invalid_argument("University enrollment cannot be negative");
    }
    if ((_enrollment > 0) && (_name.length() == 0))
    {
        throw std::invalid_argument("University cannot be anonymous");
    }
    
}