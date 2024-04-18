#include "university.h"
University::University(std::string name, int enrollment)
: _name{name}, _enrollment{enrollment}
{
    name = "";
    enrollment = 0;
    validate();
}

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
    std::string name = "";
    int enrollment = 0;
    if (ist >> name >> enrollment) reading = University{name,enrollment};
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
    if (_enrollment > 0 && name == 0)
    {
        throw std::invalid_argument("University cannot be anonymous");
    }
    
}