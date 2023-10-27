if __name__ == '__main__':
    print()

def even_or_odd(number):
    return "Even" if number % 2 == 0 else "Odd"

# return the goiven number with the digits in descending order
def descending_order(num):
    num_str = str(num)
    num_str_list = []
    num_int_list = []
    result = ""
    for i in range(len(num_str)):
        num_str_list.append(num_str[i])
    for i in num_str_list:
        num_int_list.append(int(i))
    num_int_list.sort(reverse=True)
    for i in num_int_list:
        result += str(i)
    return int(result)

def Descending_Order_short(num):
    return int(''.join(sorted(list(str(num)), reverse=True)))

# every string with 4 chars is a friend, others aren´t
def friend(x):
    result_list = []
    for name in x:
        if len(name)==4:
            result_list.append(name)
    return result_list

def friend_short(x):
    return list(filter(lambda x: len(x)==4,x))

def bubblesort_once(l):
    result_list = [item for item in l]
    for i in range(len(result_list)-1):
        if result_list[i] > result_list[i+1]:
            temp = result_list[i+1]
            result_list[i+1] = result_list[i]
            result_list[i] = temp
    return result_list

def bubblesort_once_short(l):
    result = l[:]
    for i in range(len(result)-1):
        if result[i] > result[i+1]:
            result[i], result[i+1] = result[i+1], result[i]
    return result

# find the shortest string of strings divided by spaces collected in one string
def find_short(s):
    str_list = str.split(s)
    length_of_shortest_word = len(str_list[0])
    for word in str_list:
        if len(word) < length_of_shortest_word:
            length_of_shortest_word = len(word)
    return length_of_shortest_word