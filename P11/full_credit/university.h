#ifndef __UNIVERSITY_H
#define __UNIVERSITY_H
#include <iostream>
class University
{
    private:
        std::string _name;
        int _enrollment;

    public:
        University(std::string _name, int _enrollment);
        const std::string name();
        const int enrollment();

        friend std::istream& operator>>(std::istream& ist, University& reading);
        friend std::ostream& operator<<(std::ostream& ost, const University& reading);
    private:
        void validate();
};


#endif