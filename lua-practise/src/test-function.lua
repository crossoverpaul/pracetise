function max (num1,num2)
    if  (num1 > num2) then
    	result=num1;
    else
      result=num2;
    end
    
    return result;
end

print("两值比较最大为",max(10,5));
print("两值比较最大为",max(5,6));

