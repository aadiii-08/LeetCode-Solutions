class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap< String, Double>> map = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double value = values[i];
            
            if(!map.containsKey(dividend)){
                map.put(dividend, new HashMap<String, Double>());
            }

            if(!map.containsKey(divisor)){
                map.put(divisor, new HashMap<String, Double>());
            }

            map.get(dividend).put(divisor, value);
            map.get(divisor).put(dividend, 1/value);
        }

        double[] res = new double[queries.size()];
        for(int i = 0; i < res.length; i++){
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);
            
            if(!map.containsKey(dividend) || !map.containsKey(divisor)){
                res[i] = -1.0;
            }else if(dividend.equals(divisor)){
                res[i] = 1.0;
            }else{
                HashSet<String> visited = new HashSet<>();
                res[i] = dfs(dividend, divisor, 1, visited, map);
            }
        }

        return res;
    }

    public double dfs(String src, String target, double prod, HashSet<String> visited, HashMap<String, HashMap<String, Double>> map){
        double ret = -1;
        visited.add(src);

        if(map.get(src).containsKey(target)){
            ret = map.get(src).get(target) * prod;
        }else{
            for(String neighbour : map.get(src).keySet()){
                if(!visited.contains(neighbour)){
                    ret = dfs(neighbour, target, prod * map.get(src).get(neighbour), visited, map);
                    if(ret != -1){
                        break;
                    }
                }
            }
        }
        visited.remove(src);
        return ret;
    }
}