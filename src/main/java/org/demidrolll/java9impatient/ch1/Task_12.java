package org.demidrolll.java9impatient.ch1;

public class Task_12 {
    public static void main(String[] args) {

        /*
        protected synchronized void bcsPreSerializationHook(ObjectOutputStream oos) throws IOException {

            oos.writeInt(serializable);

            if (serializable <= 0) return;

            int count = 0;

            Iterator i = services.entrySet().iterator();

            while (i.hasNext() && count < serializable) {
                Map.Entry           entry = (Map.Entry)i.next();
                BCSSServiceProvider bcsp  = null;

                try {
                    bcsp = (BCSSServiceProvider)entry.getValue();
                } catch (ClassCastException cce) {
                    continue;
                }

                if (bcsp.getServiceProvider() instanceof Serializable) {
                    oos.writeObject(entry.getKey());
                    oos.writeObject(bcsp);
                    count++;
                }
            }

            if (count != serializable)
                throw new IOException("wrote different number of service providers than expected");
        }
         */
    }
}
