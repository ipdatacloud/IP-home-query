
from IPd import IP as IpSearch


ip_str = """
"2c0f:fec0::"
"""

ip_list = []
for ip in ip_str.split("\n"):
    if not ip:
        continue
    ip = ip.replace('"', "")
    ip_list.append(ip)

finder1 = IpSearch("neww.dat")

for index,ip in enumerate(ip_list):
    result2 = finder1.get(ip)
    print(result2, "结果")
