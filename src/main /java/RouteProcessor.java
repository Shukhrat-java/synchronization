public class RouteProcessor implements Runnable {
    
    @Override
    public void run() {
        String route = Main.generateRoute("RLRFR", 100);
        int countR = 0;
        
        for (int i = 0; i < route.length(); i++) {
            if (route.charAt(i) == 'R') {
                countR++;
            }
        }
        
        System.out.println(route.substring(0, 100) + " -> " + countR);
        
        synchronized (Main.sizeToFreq) {
            if (Main.sizeToFreq.containsKey(countR)) {
                Main.sizeToFreq.put(countR, Main.sizeToFreq.get(countR) + 1);
            } else {
                Main.sizeToFreq.put(countR, 1);
            }
        }
    }
}
