#include "inch.h"


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

std::ostream& operator<<(std::ostream& ost, const Inch& rhs)
{
    ost << rhs._whole," ", rhs._numerator,"/", rhs._denominator;
    return ost;
}

std::istream& operator>>(std::istream& ist, Inch& rhs)
{
    int whole = 0;
    int numerator = 0;
    int denominator = 0;
    char div = ' ';
    ist >> whole >> numerator >> div >> denominator;
    validate(ist);
    return ist;
}


