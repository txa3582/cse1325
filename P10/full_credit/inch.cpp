#include "inch.h"
#include <numeric>

Inch::Inch(int whole, int numerator, int denominator)
:   _whole{whole}, _numerator{numerator}, _denominator{denominator}
{
    validate();
}

Inch::Inch() : Inch(0,0,2){}

Inch Inch::operator+(const Inch& rhs)
{
    int numerator = ((rhs._numerator * 64)/rhs._denominator) + ((this->_numerator * 64)/this->_denominator);
    int whole = rhs._whole + this->_whole;

    Inch* resultptr = new Inch(whole,numerator,64);
    Inch result = *resultptr;
    return result;
}

std::ostream& operator<<(std::ostream& ost, const Inch& inch)
{
    ost << inch._whole << " " << inch._numerator << "/" << inch._denominator;
    return ost;
}

std::istream& operator>>(std::istream& ist, Inch& inch)
{
    int whole = 0;
    int numerator = 0;
    int denominator = 0;
    char div = ' ';
    ist >> whole >> numerator >> div >> denominator;
    void validate();
    return ist;
}

const int Inch::compare(const Inch& rhs)
{
    // std::<double> inch1 = static_cast<double>(*this);
    // double inch2 = static_cast<double>(rhs);

    // if (inch1 < inch2) return -1;
    // if (inch1 > inch2) return 1;
    // return 0;
}

void Inch::validate()
{
    if (_denominator != 2 || _denominator != 4 || _denominator != 8 || _denominator != 16 || _denominator != 32 || _denominator != 64)
    {
        throw std::invalid_argument("Denominator must be 2, 4, 8, 16, 32, or 64");
    }
    while (_numerator > _denominator)
    {
        _numerator -= _denominator;
        _whole++;
    }
    

    int GCD = std::gcd(_numerator, _denominator);

    _numerator /= GCD;
    _denominator /= GCD;

}

