class Solution 
{
    public List<String> findItinerary(List<List<String>> tickets) 
    {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        for (List<String> ticket : tickets) 
        {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            graph.computeIfAbsent(src, k -> new PriorityQueue<>()).add(dst);
        }

        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, itinerary);
        return itinerary;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> itinerary) 
    {
        PriorityQueue<String> destinations = graph.get(airport);
        
        while (destinations != null && !destinations.isEmpty()) 
        {
            String next = destinations.poll();
            dfs(next, graph, itinerary);
        }
        
        itinerary.addFirst(airport);
    }
}