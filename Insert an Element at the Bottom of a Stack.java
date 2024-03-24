#include <stack>
using namespace std;

class Solution {
public:
    stack<int> insertAtBottom(stack<int> st, int x) {
        stack<int> temp;
        while (!st.empty()) {
            temp.push(st.top());
            st.pop();
        }
        st.push(x);
        while (!temp.empty()) {
            st.push(temp.top());
            temp.pop();
        }
        return st;
    }

    stack<int> insertAtTop(stack<int> st, int x) {
        st.push(x);
        return st;
    }
};
