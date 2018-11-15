
#!/bin/sh

function checkUser {

        status=0
        for u in $(who | awk '{print $1}' | sort | uniq)
        do
            if [ "$u" == "$1" ]; 
	    then
                    return 1
            fi
        done
        return 0
}


user=$1
checkUser $user
returnvalue=$?

if 




