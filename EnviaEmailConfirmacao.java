class EnviaEmailConfirmacao implements Runnable {
    @Override
    public void run() {
        System.out.println("Enviando email de confirmação...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Email de confirmação enviado.");
    }
}